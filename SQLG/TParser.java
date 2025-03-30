// $ANTLR 3.5.2 T.g 2025-03-30 14:56:44

import java.util.ArrayList;
import java.util.List;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class TParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ALFABETICO", "CERRAR", "CREAR", 
		"FECHA", "FIN", "ID", "INICIO", "NUMERICO", "REFERENCIA", "TABLA", "USAR", 
		"WS"
	};
	public static final int EOF=-1;
	public static final int ALFABETICO=4;
	public static final int CERRAR=5;
	public static final int CREAR=6;
	public static final int FECHA=7;
	public static final int FIN=8;
	public static final int ID=9;
	public static final int INICIO=10;
	public static final int NUMERICO=11;
	public static final int REFERENCIA=12;
	public static final int TABLA=13;
	public static final int USAR=14;
	public static final int WS=15;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public TParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public TParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return TParser.tokenNames; }
	@Override public String getGrammarFileName() { return "T.g"; }


	    List<Tabla> tablas = new ArrayList<Tabla>();  
	    Tabla tablaActual = null;
	    String databaseName = "";
	    StringBuilder sqlCode = new StringBuilder();
	    StringBuilder errors = new StringBuilder();
	    
	    // Para manejar referencias pendientes
	    class Referencia {
	        String campo;
	        String tablaRef;
	        public Referencia(String c, String t) { campo = c; tablaRef = t; }
	    }
	    List<Referencia> referenciasPendientes = new ArrayList<Referencia>();
	    
	    public void displayError(String msg) {
	        errors.append(msg + "\n");
	    }
	    
	    private String getSQLType(String tipo) {
	        if(tipo.equals("letras")) return "VARCHAR(255)";
	        if(tipo.equals("numeros")) return "INT";
	        if(tipo.equals("fecha")) return "DATE";
	        return "VARCHAR(255)";
	    }



	// $ANTLR start "inicio"
	// T.g:35:1: inicio : creacion usar ( tabla )+ cerrar ;
	public final void inicio() throws RecognitionException {
		try {
			// T.g:35:8: ( creacion usar ( tabla )+ cerrar )
			// T.g:35:11: creacion usar ( tabla )+ cerrar
			{
			pushFollow(FOLLOW_creacion_in_inicio23);
			creacion();
			state._fsp--;

			pushFollow(FOLLOW_usar_in_inicio25);
			usar();
			state._fsp--;

			// T.g:35:25: ( tabla )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==TABLA) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// T.g:35:25: tabla
					{
					pushFollow(FOLLOW_tabla_in_inicio27);
					tabla();
					state._fsp--;

					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			pushFollow(FOLLOW_cerrar_in_inicio30);
			cerrar();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "inicio"



	// $ANTLR start "creacion"
	// T.g:37:1: creacion : CREAR nombre= ID ;
	public final void creacion() throws RecognitionException {
		Token nombre=null;

		try {
			// T.g:37:10: ( CREAR nombre= ID )
			// T.g:37:12: CREAR nombre= ID
			{
			match(input,CREAR,FOLLOW_CREAR_in_creacion38); 
			nombre=(Token)match(input,ID,FOLLOW_ID_in_creacion42); 

			        databaseName = (nombre!=null?nombre.getText():null);
			        sqlCode.append("CREATE DATABASE IF NOT EXISTS " + (nombre!=null?nombre.getText():null) + ";\n");
			    
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "creacion"



	// $ANTLR start "usar"
	// T.g:43:1: usar : USAR nombre= ID ;
	public final void usar() throws RecognitionException {
		Token nombre=null;

		try {
			// T.g:43:6: ( USAR nombre= ID )
			// T.g:43:8: USAR nombre= ID
			{
			match(input,USAR,FOLLOW_USAR_in_usar57); 
			nombre=(Token)match(input,ID,FOLLOW_ID_in_usar61); 

			        sqlCode.append("USE " + (nombre!=null?nombre.getText():null) + ";\n");
			    
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "usar"



	// $ANTLR start "tabla"
	// T.g:48:1: tabla : TABLA nombre= ID INICIO ( campo )+ FIN ;
	public final void tabla() throws RecognitionException {
		Token nombre=null;

		try {
			// T.g:48:7: ( TABLA nombre= ID INICIO ( campo )+ FIN )
			// T.g:48:9: TABLA nombre= ID INICIO ( campo )+ FIN
			{
			match(input,TABLA,FOLLOW_TABLA_in_tabla76); 
			nombre=(Token)match(input,ID,FOLLOW_ID_in_tabla80); 
			match(input,INICIO,FOLLOW_INICIO_in_tabla82); 

			        // Inicializar nueva tabla
			        Tabla t = new Tabla();
			        t.nombre = (nombre!=null?nombre.getText():null);
			        tablas.add(t);
			        tablaActual = t;
			        referenciasPendientes.clear();
			        
			        // Comenzar creación de tabla SQL
			        sqlCode.append("CREATE TABLE IF NOT EXISTS " + (nombre!=null?nombre.getText():null) + " (\n");
			        sqlCode.append("    id_" + (nombre!=null?nombre.getText():null) + " INT AUTO_INCREMENT PRIMARY KEY");
			    
			// T.g:61:5: ( campo )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==ID) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// T.g:61:5: campo
					{
					pushFollow(FOLLOW_campo_in_tabla95);
					campo();
					state._fsp--;

					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			match(input,FIN,FOLLOW_FIN_in_tabla103); 

			        // Agregar todas las columnas primero
			        sqlCode.append("\n");
			        
			        // Luego agregar las constraints FOREIGN KEY
			        for (Referencia ref : referenciasPendientes) {
			            sqlCode.append(",\n    FOREIGN KEY (" + ref.campo + ") REFERENCES " + 
			                         ref.tablaRef + "(id_" + ref.tablaRef + ")");
			        }
			        
			        sqlCode.append("\n);\n\n");
			    
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "tabla"



	// $ANTLR start "campo"
	// T.g:76:1: campo : nombreCampo= ID tipoCampo= tipo ( REFERENCIA tablaRef= ID )? ;
	public final void campo() throws RecognitionException {
		Token nombreCampo=null;
		Token tablaRef=null;
		Token REFERENCIA1=null;
		ParserRuleReturnScope tipoCampo =null;

		try {
			// T.g:76:7: (nombreCampo= ID tipoCampo= tipo ( REFERENCIA tablaRef= ID )? )
			// T.g:76:9: nombreCampo= ID tipoCampo= tipo ( REFERENCIA tablaRef= ID )?
			{
			nombreCampo=(Token)match(input,ID,FOLLOW_ID_in_campo120); 
			pushFollow(FOLLOW_tipo_in_campo124);
			tipoCampo=tipo();
			state._fsp--;

			// T.g:76:39: ( REFERENCIA tablaRef= ID )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==REFERENCIA) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// T.g:76:40: REFERENCIA tablaRef= ID
					{
					REFERENCIA1=(Token)match(input,REFERENCIA,FOLLOW_REFERENCIA_in_campo127); 
					tablaRef=(Token)match(input,ID,FOLLOW_ID_in_campo131); 
					}
					break;

			}


			        // Agregar atributo a la estructura de datos
			        Atributo a = new Atributo();
			        a.nombreAtributo = (nombreCampo!=null?nombreCampo.getText():null);
			        a.tipoAtributo = (tipoCampo!=null?input.toString(tipoCampo.start,tipoCampo.stop):null);
			        if (REFERENCIA1 != null) {
			            a.referencia = (tablaRef!=null?tablaRef.getText():null);
			            // Registrar referencia para agregarla después
			            referenciasPendientes.add(new Referencia((nombreCampo!=null?nombreCampo.getText():null), (tablaRef!=null?tablaRef.getText():null)));
			        }
			        tablaActual.atributos.add(a);
			        
			        // Agregar columna a la tabla SQL
			        sqlCode.append(",\n    " + (nombreCampo!=null?nombreCampo.getText():null) + " " + getSQLType((tipoCampo!=null?input.toString(tipoCampo.start,tipoCampo.stop):null)));
			    
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "campo"


	public static class tipo_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "tipo"
	// T.g:93:1: tipo : ( NUMERICO | ALFABETICO | FECHA ) ;
	public final TParser.tipo_return tipo() throws RecognitionException {
		TParser.tipo_return retval = new TParser.tipo_return();
		retval.start = input.LT(1);

		try {
			// T.g:93:6: ( ( NUMERICO | ALFABETICO | FECHA ) )
			// T.g:
			{
			if ( input.LA(1)==ALFABETICO||input.LA(1)==FECHA||input.LA(1)==NUMERICO ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "tipo"



	// $ANTLR start "cerrar"
	// T.g:95:1: cerrar : CERRAR ;
	public final void cerrar() throws RecognitionException {
		try {
			// T.g:95:8: ( CERRAR )
			// T.g:95:10: CERRAR
			{
			match(input,CERRAR,FOLLOW_CERRAR_in_cerrar166); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "cerrar"

	// Delegated rules



	public static final BitSet FOLLOW_creacion_in_inicio23 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_usar_in_inicio25 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_tabla_in_inicio27 = new BitSet(new long[]{0x0000000000002020L});
	public static final BitSet FOLLOW_cerrar_in_inicio30 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CREAR_in_creacion38 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_ID_in_creacion42 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_USAR_in_usar57 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_ID_in_usar61 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TABLA_in_tabla76 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_ID_in_tabla80 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_INICIO_in_tabla82 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_campo_in_tabla95 = new BitSet(new long[]{0x0000000000000300L});
	public static final BitSet FOLLOW_FIN_in_tabla103 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_campo120 = new BitSet(new long[]{0x0000000000000890L});
	public static final BitSet FOLLOW_tipo_in_campo124 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_REFERENCIA_in_campo127 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_ID_in_campo131 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CERRAR_in_cerrar166 = new BitSet(new long[]{0x0000000000000002L});
}
