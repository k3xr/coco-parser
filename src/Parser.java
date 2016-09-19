import java.io.FileWriter;
import java.io.IOException;



public class Parser {
	public static final int _EOF = 0;
	public static final int _ident = 1;
	public static final int _integer = 2;
	public static final int _string = 3;
	public static final int _eolT = 4;
	public static final int _var = 5;
	public static final int maxT = 27;

	static final boolean T = true;
	static final boolean x = false;
	static final int minErrDist = 2;

	public static Token t;    // last recognized token
	public Token la;   // lookahead token
	static int errDist = minErrDist;

	public Scanner scanner;
	public static Errors errors;



	public Parser(Scanner scanner) {
		this.scanner = scanner;
		errors = new Errors();
	}

	void SynErr (int n) {
		if (errDist >= minErrDist) errors.SynErr(la.line, la.col, n);
		errDist = 0;
	}

	public static void SemErr (String msg) {
		if (errDist >= minErrDist) errors.SemErr(t.line, t.col, msg);
		errDist = 0;
	}

	void Get () {
		for (;;) {
			t = la;
			la = scanner.Scan();
			String filename= "tokens.txt";
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write(la.val+"\n\r");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (la.kind <= maxT) {
				++errDist;
				break;
			}

			la = t;
		}
	}

	void Expect (int n) {
		if (la.kind==n) Get(); else { SynErr(n); }
	}

	boolean StartOf (int s) {
		return set[s][la.kind];
	}

	void ExpectWeak (int n, int follow) {
		if (la.kind == n) Get();
		else {
			SynErr(n);
			while (!StartOf(follow)) Get();
		}
	}

	boolean WeakSeparator (int n, int syFol, int repFol) {
		int kind = la.kind;
		if (kind == n) { Get(); return true; }
		else if (StartOf(repFol)) return false;
		else {
			SynErr(n);
			while (!(set[syFol][kind] || set[repFol][kind] || set[0][kind])) {
				Get();
				kind = la.kind;
			}
			return StartOf(syFol);
		}
	}

	void Javascript() throws IOException {
		TL.Init(); TL.EnterScope(); 
		//Print “Descendente”
		String filename= "parse.txt";
		try {
			FileWriter fw = new FileWriter(filename,true);
			fw.write("Descendente ");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Print 1
		try {
			FileWriter fw = new FileWriter(filename,true);
			fw.write("1 ");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (StartOf(1)) {
			if (StartOf(2)) {
				//Print 2
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("2 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if(la.kind == 7){
					//Print 10
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("10 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else if(la.kind == 10){
					//Print 11 
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("11 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else if(la.kind == 5){
					//Print 12 
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("12 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else if(la.kind == 1){
					//Print 13 
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("13 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				SENTENCIA();
			} else if (la.kind == 23) {
				//Print 3
				//Print 51
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("3 51 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				FUNCION();
			} else if (la.kind == 4 || la.kind == 6) {
				//Print 4
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("4 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if(la.kind == 6){
					//Print 8
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("8 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else if(la.kind == 4){
					//Print 9
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("9 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				FINLINEA();
			} else if (la.kind == 25) {
				// Print 5
				// Print 71
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("5 71 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				IFFPPAL();
			} else {
				// Print 6
				// Print 73
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("6 73 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				WHILEFPPAL();
			}
		}
		//Print 7
		try {
			FileWriter fw = new FileWriter(filename,true);
			fw.write("7 ");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		TL.LeaveScope(); 
	}

	void SENTENCIA() throws IOException {
		String filename= "parse.txt";
		if (la.kind == 7) {
			//Print 14 
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("14 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			WRITE();
		} else if (la.kind == 10) {
			//Print 17
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("17 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			PROMPT();
		} else if (la.kind == 5) {
			//Print 23
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("23 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			DECLARACION();
		} else if (la.kind == 1) {
			//Print 20
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("20 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			LLAMADAYASIGNACION();
		} else SynErr(28);
		if(la.kind == 6){
			//Print 8
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("8 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(la.kind == 4){
			//Print 9
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("9 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		FINLINEA();
	}

	void FUNCION() throws IOException {
		String filename= "parse.txt";
		String name; Obj obj; 
		Expect(23);
		name = Ident();
		obj = TL.NewObj(name, TL.procs); 
		TL.EnterScope(); 
		//Print 52
		try {
			FileWriter fw = new FileWriter(filename,true);
			fw.write("52 ");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ARGUMENTOS();
		Expect(16);
		if(la.kind == 7 || la.kind == 10 || la.kind == 5 || la.kind == 1){
			//Print 57
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("57 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if (la.kind == 24) {
			//Print 58
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("58 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if (la.kind == 6 || la.kind == 4) {
			//Print 59
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("59 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if (la.kind == 25) {
			//Print 60
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("60 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if (la.kind == 26) {
			//Print 61
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("61 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
		CUERPO();
		Expect(18);
		TL.LeaveScope(); 
	}

	void FINLINEA() {
		if (la.kind == 6) {
			Get();
		} else if (la.kind == 4) {
			Get();
		} else SynErr(29);
	}

	void IFFPPAL() throws IOException {
		String filename= "parse.txt";
		Expect(25);
		Expect(8);
		if(la.kind == 19){
			//Print 34
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("34 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(la.kind == 8 ||  la.kind == 1 ||  la.kind == 22 || la.kind == 2){
			//Print 35
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("35 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		EXPRESIONBOOL();
		Expect(9);
		// Print 20
		try {
			FileWriter fw = new FileWriter(filename,true);
			fw.write("20 ");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		LLAMADAYASIGNACION();
	}

	void WHILEFPPAL() throws IOException {
		String filename= "parse.txt";
		Expect(26);
		Expect(8);
		if(la.kind == 19){
			//Print 34
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("34 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(la.kind == 8 ||  la.kind == 1 ||  la.kind == 22|| la.kind == 2 ){
			//Print 35
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("35 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		EXPRESIONBOOL();
		Expect(9);
		Expect(16);
		while (StartOf(3)) {
			if (StartOf(2)) {
				//Print 74
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("74 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if(la.kind == 7){
					//Print 10 
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("10 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else if(la.kind == 10){
					//Print 11 
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("11 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else if(la.kind == 5){
					//Print 12 
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("12 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else if(la.kind == 1){
					//Print 13 
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("13 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				SENTENCIA();
			} else if(la.kind == 6 || la.kind == 4){
				//Print 75
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("75 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if(la.kind == 6){
					//Print 8
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("8 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else if(la.kind == 4){
					//Print 9
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("9 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				FINLINEA();
			}
			else{
				//Print 76
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("76 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		Expect(18);
		if(la.kind == 6){
			//Print 8
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("8 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(la.kind == 4){
			//Print 9
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("9 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		FINLINEA();
	}

	void WRITE() throws IOException {
		String filename= "parse.txt";
		Expect(7);
		Expect(8);
		if (StartOf(4)) {
			// Print 15
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("15 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(la.kind == 19){
				//Print 34
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("34 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(la.kind == 8 ||  la.kind == 1 ||  la.kind == 22 || la.kind == 2){
				//Print 35
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("35 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}		
			EXPRESIONBOOL();
		} else if (la.kind == 3) {
			//Print 16
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("16 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Get();
		} else SynErr(30);
		Expect(9);
	}

	void PROMPT() throws IOException {
		String filename= "parse.txt";
		Expect(10);
		Expect(8);
		Expect(1);
		if (la.kind == 11) {
			//Print 19
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("19 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Get();
			if(la.kind == 1 || la.kind == 22|| la.kind == 2){
				//Print 38
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("38 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else if(la.kind == 8){
				//Print 39
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("39 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			EXPRESION();
			Expect(12);
		}
		else{
			//Print 18
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("18 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Expect(9);
	}

	void DECLARACION() throws IOException {
		String filename= "parse.txt";
		String name; Obj obj; 
		Expect(5);
		name = Ident();
		obj = TL.NewObj(name, TL.vars); 
		if (la.kind == 13) {
			//Print 25
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("25 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Get();
			Expect(14);
			Expect(15);
			Expect(8);
			if(la.kind == 1 || la.kind == 22|| la.kind == 2){
				//Print 38
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("38 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else if(la.kind == 8){
				//Print 39
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("39 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			EXPRESION();
			Expect(9);
			obj.type = TL.arr; 
		}
		else{
			//Print 24
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("24 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	void LLAMADAYASIGNACION() throws IOException {
		String filename= "parse.txt";

		Expect(1);
		if (la.kind == 11 || la.kind == 13) {
			//Print 21
			//Print 26
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("21 26 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			ASIGNACION();
		} else if (la.kind == 8) {
			//Print 22
			//Print 77
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("22 77 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			LLAMADAFUNCION();
		} else SynErr(31);
	}

	void EXPRESIONBOOL() throws IOException {
		String filename= "parse.txt";

		if (la.kind == 19) {
			Get();
			if(la.kind == 1 || la.kind == 22|| la.kind == 2){
				//Print 38
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("38 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else if(la.kind == 8){
				//Print 39
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("39 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			EXPRESION();
			Expect(20);
			if(la.kind == 1 || la.kind == 22|| la.kind == 2){
				//Print 38
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("38 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else if(la.kind == 8){
				//Print 39
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("39 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			EXPRESION();
		} else if (StartOf(5)) {

			if(la.kind == 1 || la.kind == 22|| la.kind == 2){
				//Print 38
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("38 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else if(la.kind == 8){
				//Print 39
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("39 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			EXPRESION();
			while (la.kind == 20) {
				// Print 36
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("36 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Get();
				if(la.kind == 1 || la.kind == 22 || la.kind == 2 ){
					//Print 38
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("38 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else if(la.kind == 8){
					//Print 39
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("39 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				EXPRESION();
			}
			//Print 37
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("37 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else SynErr(32);
	}

	void EXPRESION() throws IOException {
		String filename= "parse.txt";

		if (la.kind == 1 || la.kind == 2 || la.kind == 22) {
			if(la.kind == 2 || la.kind == 22){
				//Print 42
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("42 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else if(la.kind == 1){
				//Print 43
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("43 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			NUMEROoIDENT();
			if (la.kind == 21) {
				//Print 40
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("40 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Get();
				if(la.kind == 1 || la.kind == 22|| la.kind == 2){
					//Print 38
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("38 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else if(la.kind == 8){
					//Print 39
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("39 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				EXPRESION();
			}
			else{
				//Print 41
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("41 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else if (la.kind == 8) {
			Get();
			//Print 50
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("50 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			EXPPARENTESIS();
		} else SynErr(33);
	}

	void ASIGNACION() throws IOException {
		String filename= "parse.txt";
		if (la.kind == 11) {
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("27 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Get();
			if(la.kind == 1 || la.kind == 22|| la.kind == 2){
				//Print 38
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("38 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else if(la.kind == 8){
				//Print 39
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("39 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			EXPRESION();
			Expect(12);
			Expect(13);
			if(la.kind == 19){
				//Print 34
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("34 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(la.kind == 8 ||  la.kind == 1 ||  la.kind == 22 || la.kind == 2){
				//Print 35
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("35 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			EXPRESIONBOOL();
		} else if (la.kind == 13) {
			//Print 28
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("28 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Get();
			if (StartOf(4)) {
				//Print 29
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("29 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if(la.kind == 19){
					//Print 34
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("34 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(la.kind == 8 ||  la.kind == 1 ||  la.kind == 22|| la.kind == 2 ){
					//Print 35
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("35 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				EXPRESIONBOOL();
			} else if (la.kind == 3) {
				//Print 30
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("30 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Get();
			} else if (la.kind == 16) {
				//Print 31
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("31 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Get();
				if(la.kind == 1 || la.kind == 22|| la.kind == 2){
					//Print 38
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("38 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else if(la.kind == 8){
					//Print 39
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("39 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				EXPRESION();
				while (la.kind == 17) {
					//Print 32
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("32 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					Get();
					if(la.kind == 1 || la.kind == 22|| la.kind == 2){
						//Print 3
						try {
							FileWriter fw = new FileWriter(filename,true);
							fw.write("3 ");
							fw.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					else if(la.kind == 8){
						//Print 39
						try {
							FileWriter fw = new FileWriter(filename,true);
							fw.write("39 ");
							fw.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					EXPRESION();
				}
				//Print 33
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("33 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Expect(18);
			} else SynErr(34);
		} else SynErr(35);
	}

	void LLAMADAFUNCION() throws IOException {
		String filename= "parse.txt";

		Expect(8);
		if (StartOf(4)) {
			//Print 79
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("79 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(la.kind == 19){
				//Print 34
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("34 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(la.kind == 8 ||  la.kind == 1 ||  la.kind == 22|| la.kind == 2 ){
				//Print 35
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("35 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			EXPRESIONBOOL();
			while (la.kind == 17) {
				//Print 81
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("81 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Get();
				if(la.kind == 19){
					//Print 34
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("34 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(la.kind == 8 ||  la.kind == 1 ||  la.kind == 22 || la.kind == 2){
					//Print 35
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("35 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}	
				EXPRESIONBOOL();
			}
			//Print 80
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("80 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{
			//Print 78
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("78 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Expect(9);
	}

	String  Ident() {
		String  name;
		Expect(1);
		name = t.val; 
		return name;
	}

	void NUMEROoIDENT() throws IOException {
		String filename= "parse.txt";

		String name; Obj obj; 
		if (la.kind == 2 || la.kind == 22) {
			if (la.kind == 22) {
				//Print 44
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("44 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Get();
			}
			else{
				//Print 45
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("45 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			Expect(2);
		} else if (la.kind == 1) {
			name = Ident();
			obj = TL.This(name); 

			if (la.kind == 8 || la.kind == 11) {
				//Print 46
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("46 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (la.kind == 11) {
					//Print 48
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("48 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					Get();
					if(la.kind == 1 || la.kind == 22|| la.kind == 2){
						//Print 38
						try {
							FileWriter fw = new FileWriter(filename,true);
							fw.write("38 ");
							fw.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					else if(la.kind == 8){
						//Print 39
						try {
							FileWriter fw = new FileWriter(filename,true);
							fw.write("39 ");
							fw.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					EXPRESION();
					Expect(12);
				} else {
					//Print 49
					//Print 77
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("49 77 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					LLAMADAFUNCION();
				}
			}
			else{
				//Print 47
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("47 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else SynErr(36);
	}

	void EXPPARENTESIS() throws IOException {
		String filename= "parse.txt";

		if(la.kind == 1 || la.kind == 22|| la.kind == 2){
			//Print 38
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("38 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(la.kind == 8){
			//Print 39
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("39 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		EXPRESION();
		Expect(9);
	}

	void ARGUMENTOS() throws IOException {
		String filename= "parse.txt";
		String name; Obj obj; 
		Expect(8);
		
		if(la.kind == 9){
			//Print 53
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("53 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
		while (la.kind == 1) {
			//Print 54
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("54 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			name = Ident();
			obj = TL.NewObj(name, TL.vars); 
			while (la.kind == 17) {
				//Print 56
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("56 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Get();
				name = Ident();
				obj = TL.NewObj(name, TL.vars); 
			}
			//Print 55
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("55 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		Expect(9);
	}

	void CUERPO() throws IOException {
		String filename= "parse.txt";
		boolean llamada = false;
		while (StartOf(6)) {
			if(llamada){
				if(la.kind == 7 || la.kind == 10 || la.kind == 5 || la.kind == 1){
					//Print 57
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("57 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else if (la.kind == 24) {
					//Print 58
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("58 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else if (la.kind == 6 || la.kind == 4) {
					//Print 59
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("59 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else if (la.kind == 25) {
					//Print 60
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("60 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else if (la.kind == 26) {
					//Print 61
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("61 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			llamada = true;
			if (StartOf(2)) {
				if(la.kind == 7){
					//Print 10
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("10 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else if(la.kind == 10){
					//Print 11 
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("11 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else if(la.kind == 5){
					//Print 12 
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("12 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else if(la.kind == 1){
					//Print 13 
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("13 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				SENTENCIA();
			} else if (la.kind == 24) {
				//Print 63
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("63 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				RETURN();
			} else if (la.kind == 4 || la.kind == 6) {
				if(la.kind == 6){
					//Print 8
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("8 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else if(la.kind == 4){
					//Print 9
					try {
						FileWriter fw = new FileWriter(filename,true);
						fw.write("9 ");
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				FINLINEA();
			} else if (la.kind == 25) {
				//Print 66
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("66 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				IFFUNCION();
			} else {
				//Print 72
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("72 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				WHILEFUNCION();
			}
			
		}
		//Print 62
		try {
			FileWriter fw = new FileWriter(filename,true);
			fw.write("62 ");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	void RETURN() throws IOException {
		String filename= "parse.txt";

		Expect(24);
		if (StartOf(4)) {
			//Print 65
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("65 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(la.kind == 19){
				//Print 34
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("34 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(la.kind == 8 ||  la.kind == 1 ||  la.kind == 22|| la.kind == 2 ){
				//Print 35
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("35 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			EXPRESIONBOOL();
		}
		else{
			//Print 64
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("64 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(la.kind == 6){
			//Print 8
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("8 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(la.kind == 4){
			//Print 9
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("9 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		FINLINEA();
	}

	void IFFUNCION() throws IOException {
		String filename= "parse.txt";

		Expect(25);
		Expect(8);
		if(la.kind == 19){
			//Print 34
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("34 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(la.kind == 8 ||  la.kind == 1 ||  la.kind == 22 || la.kind == 2){
			//Print 35
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("35 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		EXPRESIONBOOL();
		Expect(9);
		while (la.kind == 4 || la.kind == 6) {
			//Print 67
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("67 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(la.kind == 6){
				//Print 8
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("8 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else if(la.kind == 4){
				//Print 9
				try {
					FileWriter fw = new FileWriter(filename,true);
					fw.write("9 ");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}	
			FINLINEA();
		}
		//Print 68
		try {
			FileWriter fw = new FileWriter(filename,true);
			fw.write("68 ");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (la.kind == 1) {
			//Print 69
			//Print 20
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("69 20 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			LLAMADAYASIGNACION();
		} else if (la.kind == 24) {
			//Print 70
			//Print 63
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("70 63 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			RETURN();
		} else SynErr(37);
	}

	void WHILEFUNCION() throws IOException {
		String filename= "parse.txt";

		Expect(26);
		Expect(8);
		if(la.kind == 19){
			//Print 34
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("34 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(la.kind == 8 ||  la.kind == 1 ||  la.kind == 22 || la.kind == 2){
			//Print 35
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("35 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		EXPRESIONBOOL();
		Expect(9);
		Expect(16);
		if(la.kind == 7 || la.kind == 10 || la.kind == 5 || la.kind == 1){
			//Print 57
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("57 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if (la.kind == 24) {
			//Print 58
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("58 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if (la.kind == 6 || la.kind == 4) {
			//Print 59
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("59 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if (la.kind == 25) {
			//Print 60
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("60 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if (la.kind == 26) {
			//Print 61
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("61 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		CUERPO();
		Expect(18);
		if(la.kind == 6){
			//Print 8
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("8 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(la.kind == 4){
			//Print 9
			try {
				FileWriter fw = new FileWriter(filename,true);
				fw.write("9 ");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		FINLINEA();
	}




	public void Parse() throws IOException {
		la = new Token();
		la.val = "";		
		Get();
		Javascript();
		Expect(0);

	}

	private static final boolean[][] set = {
		{T,x,x,x, x,x,x,x, x,x,x,x, x,x,x,x, x,x,x,x, x,x,x,x, x,x,x,x, x},
		{x,T,x,x, T,T,T,T, x,x,T,x, x,x,x,x, x,x,x,x, x,x,x,T, x,T,T,x, x},
		{x,T,x,x, x,T,x,T, x,x,T,x, x,x,x,x, x,x,x,x, x,x,x,x, x,x,x,x, x},
		{x,T,x,x, T,T,T,T, x,x,T,x, x,x,x,x, x,x,x,x, x,x,x,x, x,x,x,x, x},
		{x,T,T,x, x,x,x,x, T,x,x,x, x,x,x,x, x,x,x,T, x,x,T,x, x,x,x,x, x},
		{x,T,T,x, x,x,x,x, T,x,x,x, x,x,x,x, x,x,x,x, x,x,T,x, x,x,x,x, x},
		{x,T,x,x, T,T,T,T, x,x,T,x, x,x,x,x, x,x,x,x, x,x,x,x, T,T,T,x, x}

	};
} // end Parser


class Errors {
	public int count = 0;                                    // number of errors detected
	public java.io.PrintStream errorStream = System.out;     // error messages go to this stream
	public String errMsgFormat = "-- line {0} col {1}: {2}"; // 0=line, 1=column, 2=text

	protected void printMsg(int line, int column, String msg) {
		StringBuffer b = new StringBuffer(errMsgFormat);
		int pos = b.indexOf("{0}");
		if (pos >= 0) { b.delete(pos, pos+3); b.insert(pos, line); }
		pos = b.indexOf("{1}");
		if (pos >= 0) { b.delete(pos, pos+3); b.insert(pos, column); }
		pos = b.indexOf("{2}");
		if (pos >= 0) b.replace(pos, pos+3, msg);
		errorStream.println(b.toString());
	}

	public void SynErr (int line, int col, int n) {
		String s;
		switch (n) {
		case 0: s = "EOF expected"; break;
		case 1: s = "ident expected"; break;
		case 2: s = "integer expected"; break;
		case 3: s = "string expected"; break;
		case 4: s = "eolT expected"; break;
		case 5: s = "var expected"; break;
		case 6: s = "\";\" expected"; break;
		case 7: s = "\"document.write\" expected"; break;
		case 8: s = "\"(\" expected"; break;
		case 9: s = "\")\" expected"; break;
		case 10: s = "\"prompt\" expected"; break;
		case 11: s = "\"[\" expected"; break;
		case 12: s = "\"]\" expected"; break;
		case 13: s = "\"=\" expected"; break;
		case 14: s = "\"new\" expected"; break;
		case 15: s = "\"Array\" expected"; break;
		case 16: s = "\"{\" expected"; break;
		case 17: s = "\",\" expected"; break;
		case 18: s = "\"}\" expected"; break;
		case 19: s = "\"!\" expected"; break;
		case 20: s = "\"<\" expected"; break;
		case 21: s = "\"+\" expected"; break;
		case 22: s = "\"++\" expected"; break;
		case 23: s = "\"function\" expected"; break;
		case 24: s = "\"return\" expected"; break;
		case 25: s = "\"if\" expected"; break;
		case 26: s = "\"while\" expected"; break;
		case 27: s = "??? expected"; break;
		case 28: s = "invalid SENTENCIA"; break;
		case 29: s = "invalid FINLINEA"; break;
		case 30: s = "invalid WRITE"; break;
		case 31: s = "invalid LLAMADAYASIGNACION"; break;
		case 32: s = "invalid EXPRESIONBOOL"; break;
		case 33: s = "invalid EXPRESION"; break;
		case 34: s = "invalid ASIGNACION"; break;
		case 35: s = "invalid ASIGNACION"; break;
		case 36: s = "invalid NUMEROoIDENT"; break;
		case 37: s = "invalid IFFUNCION"; break;
		default: s = "error " + n; break;
		}
		printMsg(line, col, s);
		count++;
	}

	public void SemErr (int line, int col, String s) {	
		printMsg(line, col, s);
		count++;
	}

	public void SemErr (String s) {
		errorStream.println(s);
		count++;
	}

	public void Warning (int line, int col, String s) {	
		printMsg(line, col, s);
	}

	public void Warning (String s) {
		errorStream.println(s);
	}
} // Errors


class FatalError extends RuntimeException {
	public static final long serialVersionUID = 1L;
	public FatalError(String s) { super(s); }
}
