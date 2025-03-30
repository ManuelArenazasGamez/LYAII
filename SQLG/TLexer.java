// $ANTLR 3.5.2 T.g 2025-03-30 14:56:44

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class TLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public TLexer() {} 
	public TLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public TLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "T.g"; }

	// $ANTLR start "CERRAR"
	public final void mCERRAR() throws RecognitionException {
		try {
			int _type = CERRAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// T.g:98:12: ( 'cerrar' )
			// T.g:98:14: 'cerrar'
			{
			match("cerrar"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CERRAR"

	// $ANTLR start "NUMERICO"
	public final void mNUMERICO() throws RecognitionException {
		try {
			int _type = NUMERICO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// T.g:99:12: ( 'numeros' )
			// T.g:99:14: 'numeros'
			{
			match("numeros"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUMERICO"

	// $ANTLR start "ALFABETICO"
	public final void mALFABETICO() throws RecognitionException {
		try {
			int _type = ALFABETICO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// T.g:100:12: ( 'letras' )
			// T.g:100:14: 'letras'
			{
			match("letras"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ALFABETICO"

	// $ANTLR start "FECHA"
	public final void mFECHA() throws RecognitionException {
		try {
			int _type = FECHA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// T.g:101:12: ( 'fecha' )
			// T.g:101:14: 'fecha'
			{
			match("fecha"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FECHA"

	// $ANTLR start "TABLA"
	public final void mTABLA() throws RecognitionException {
		try {
			int _type = TABLA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// T.g:102:12: ( 'tabla' )
			// T.g:102:14: 'tabla'
			{
			match("tabla"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TABLA"

	// $ANTLR start "INICIO"
	public final void mINICIO() throws RecognitionException {
		try {
			int _type = INICIO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// T.g:103:12: ( 'inicio' )
			// T.g:103:14: 'inicio'
			{
			match("inicio"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INICIO"

	// $ANTLR start "FIN"
	public final void mFIN() throws RecognitionException {
		try {
			int _type = FIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// T.g:104:12: ( 'fin' )
			// T.g:104:14: 'fin'
			{
			match("fin"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FIN"

	// $ANTLR start "USAR"
	public final void mUSAR() throws RecognitionException {
		try {
			int _type = USAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// T.g:105:12: ( 'usar' )
			// T.g:105:14: 'usar'
			{
			match("usar"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "USAR"

	// $ANTLR start "CREAR"
	public final void mCREAR() throws RecognitionException {
		try {
			int _type = CREAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// T.g:106:12: ( 'crear' )
			// T.g:106:14: 'crear'
			{
			match("crear"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CREAR"

	// $ANTLR start "REFERENCIA"
	public final void mREFERENCIA() throws RecognitionException {
		try {
			int _type = REFERENCIA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// T.g:107:12: ( 'depende_de' )
			// T.g:107:14: 'depende_de'
			{
			match("depende_de"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "REFERENCIA"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// T.g:109:7: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// T.g:109:9: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// T.g:109:33: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// T.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop1;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// T.g:110:7: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
			// T.g:110:9: ( ' ' | '\\t' | '\\r' | '\\n' )+
			{
			// T.g:110:9: ( ' ' | '\\t' | '\\r' | '\\n' )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '\t' && LA2_0 <= '\n')||LA2_0=='\r'||LA2_0==' ') ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// T.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// T.g:1:8: ( CERRAR | NUMERICO | ALFABETICO | FECHA | TABLA | INICIO | FIN | USAR | CREAR | REFERENCIA | ID | WS )
		int alt3=12;
		alt3 = dfa3.predict(input);
		switch (alt3) {
			case 1 :
				// T.g:1:10: CERRAR
				{
				mCERRAR(); 

				}
				break;
			case 2 :
				// T.g:1:17: NUMERICO
				{
				mNUMERICO(); 

				}
				break;
			case 3 :
				// T.g:1:26: ALFABETICO
				{
				mALFABETICO(); 

				}
				break;
			case 4 :
				// T.g:1:37: FECHA
				{
				mFECHA(); 

				}
				break;
			case 5 :
				// T.g:1:43: TABLA
				{
				mTABLA(); 

				}
				break;
			case 6 :
				// T.g:1:49: INICIO
				{
				mINICIO(); 

				}
				break;
			case 7 :
				// T.g:1:56: FIN
				{
				mFIN(); 

				}
				break;
			case 8 :
				// T.g:1:60: USAR
				{
				mUSAR(); 

				}
				break;
			case 9 :
				// T.g:1:65: CREAR
				{
				mCREAR(); 

				}
				break;
			case 10 :
				// T.g:1:71: REFERENCIA
				{
				mREFERENCIA(); 

				}
				break;
			case 11 :
				// T.g:1:82: ID
				{
				mID(); 

				}
				break;
			case 12 :
				// T.g:1:85: WS
				{
				mWS(); 

				}
				break;

		}
	}


	protected DFA3 dfa3 = new DFA3(this);
	static final String DFA3_eotS =
		"\1\uffff\10\11\2\uffff\17\11\1\44\11\11\1\uffff\2\11\1\60\2\11\1\63\2"+
		"\11\1\66\1\67\1\11\1\uffff\1\11\1\72\1\uffff\1\11\1\74\2\uffff\1\75\1"+
		"\11\1\uffff\1\77\2\uffff\1\11\1\uffff\2\11\1\103\1\uffff";
	static final String DFA3_eofS =
		"\104\uffff";
	static final String DFA3_minS =
		"\1\11\1\145\1\165\2\145\1\141\1\156\1\163\1\145\2\uffff\1\162\1\145\1"+
		"\155\1\164\1\143\1\156\1\142\1\151\1\141\1\160\1\162\1\141\1\145\1\162"+
		"\1\150\1\60\1\154\1\143\1\162\1\145\1\141\2\162\2\141\1\uffff\1\141\1"+
		"\151\1\60\1\156\1\162\1\60\1\157\1\163\2\60\1\157\1\uffff\1\144\1\60\1"+
		"\uffff\1\163\1\60\2\uffff\1\60\1\145\1\uffff\1\60\2\uffff\1\137\1\uffff"+
		"\1\144\1\145\1\60\1\uffff";
	static final String DFA3_maxS =
		"\1\172\1\162\1\165\1\145\1\151\1\141\1\156\1\163\1\145\2\uffff\1\162\1"+
		"\145\1\155\1\164\1\143\1\156\1\142\1\151\1\141\1\160\1\162\1\141\1\145"+
		"\1\162\1\150\1\172\1\154\1\143\1\162\1\145\1\141\2\162\2\141\1\uffff\1"+
		"\141\1\151\1\172\1\156\1\162\1\172\1\157\1\163\2\172\1\157\1\uffff\1\144"+
		"\1\172\1\uffff\1\163\1\172\2\uffff\1\172\1\145\1\uffff\1\172\2\uffff\1"+
		"\137\1\uffff\1\144\1\145\1\172\1\uffff";
	static final String DFA3_acceptS =
		"\11\uffff\1\13\1\14\31\uffff\1\7\13\uffff\1\10\2\uffff\1\11\2\uffff\1"+
		"\4\1\5\2\uffff\1\1\1\uffff\1\3\1\6\1\uffff\1\2\3\uffff\1\12";
	static final String DFA3_specialS =
		"\104\uffff}>";
	static final String[] DFA3_transitionS = {
			"\2\12\2\uffff\1\12\22\uffff\1\12\40\uffff\32\11\4\uffff\1\11\1\uffff"+
			"\2\11\1\1\1\10\1\11\1\4\2\11\1\6\2\11\1\3\1\11\1\2\5\11\1\5\1\7\5\11",
			"\1\13\14\uffff\1\14",
			"\1\15",
			"\1\16",
			"\1\17\3\uffff\1\20",
			"\1\21",
			"\1\22",
			"\1\23",
			"\1\24",
			"",
			"",
			"\1\25",
			"\1\26",
			"\1\27",
			"\1\30",
			"\1\31",
			"\1\32",
			"\1\33",
			"\1\34",
			"\1\35",
			"\1\36",
			"\1\37",
			"\1\40",
			"\1\41",
			"\1\42",
			"\1\43",
			"\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
			"\1\45",
			"\1\46",
			"\1\47",
			"\1\50",
			"\1\51",
			"\1\52",
			"\1\53",
			"\1\54",
			"\1\55",
			"",
			"\1\56",
			"\1\57",
			"\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
			"\1\61",
			"\1\62",
			"\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
			"\1\64",
			"\1\65",
			"\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
			"\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
			"\1\70",
			"",
			"\1\71",
			"\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
			"",
			"\1\73",
			"\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
			"",
			"",
			"\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
			"\1\76",
			"",
			"\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
			"",
			"",
			"\1\100",
			"",
			"\1\101",
			"\1\102",
			"\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
			""
	};

	static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
	static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
	static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
	static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
	static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
	static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
	static final short[][] DFA3_transition;

	static {
		int numStates = DFA3_transitionS.length;
		DFA3_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
		}
	}

	protected class DFA3 extends DFA {

		public DFA3(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 3;
			this.eot = DFA3_eot;
			this.eof = DFA3_eof;
			this.min = DFA3_min;
			this.max = DFA3_max;
			this.accept = DFA3_accept;
			this.special = DFA3_special;
			this.transition = DFA3_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( CERRAR | NUMERICO | ALFABETICO | FECHA | TABLA | INICIO | FIN | USAR | CREAR | REFERENCIA | ID | WS );";
		}
	}

}
