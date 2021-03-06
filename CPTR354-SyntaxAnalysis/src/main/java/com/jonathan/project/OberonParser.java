/* OberonParser.java */
/* Generated By:JavaCC: Do not edit this line. OberonParser.java */
package com.jonathan.project;
public final class OberonParser implements OberonParserConstants { // Standard parser class setup...

  public static void main(String args[]) {
    OberonParser parser;
    java.io.InputStream input;

    if (args.length==1) {
      System.out.print(args[args.length-1] + ": ");
      try {
        input = new java.io.FileInputStream(args[args.length-1]);
      } catch (java.io.FileNotFoundException e) {
        System.out.println("File not found.");
        return;
      }
    } else if (args.length==0) {
      System.out.println("Reading from standard input...");
      input = System.in;
    } else {
      System.out.println("Usage: java OberonParser [inputfile]");
      return;
    }
    try {
      parser = new OberonParser(input);
      parser.translation_unit();
      System.out.println("Successful parse!");
    } catch (ParseException e) {
      String msg = e.getMessage();
      msg = msg.substring(0,msg.indexOf("\u005cn"));
      System.out.println("Syntax Error: "+msg);
    }
  }

/**************************************/
/********** START OF GRAMMAR **********/
/**************************************/
  static final public
void translation_unit() throws ParseException {
    Module();
  }

  static final public void Module() throws ParseException {
    jj_consume_token(MODULE);
    jj_consume_token(IDENT);
    jj_consume_token(54);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case IMPORT:{
      ImportList();
      break;
      }
    default:
      jj_la1[0] = jj_gen;
      ;
    }
    DeclSeq();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case BEGIN:{
      jj_consume_token(BEGIN);
      StatementSeq();
      break;
      }
    default:
      jj_la1[1] = jj_gen;
      ;
    }
    jj_consume_token(END);
    jj_consume_token(IDENT);
    jj_consume_token(55);
  }

  static final public void ImportList() throws ParseException {
    jj_consume_token(IMPORT);
    ImportSpec();
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 56:{
        ;
        break;
        }
      default:
        jj_la1[2] = jj_gen;
        break label_1;
      }
      jj_consume_token(56);
      ImportSpec();
    }
    jj_consume_token(54);
  }

  static final public void ImportSpec() throws ParseException {
    jj_consume_token(IDENT);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 57:{
      jj_consume_token(57);
      jj_consume_token(IDENT);
      break;
      }
    default:
      jj_la1[3] = jj_gen;
      ;
    }
  }

  static final public void DeclSeq() throws ParseException {
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case CONST:
      case TYPE:
      case VAR:{
        ;
        break;
        }
      default:
        jj_la1[4] = jj_gen;
        break label_2;
      }
      VarTypeDecl();
    }
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case PROCEDURE:{
        ;
        break;
        }
      default:
        jj_la1[5] = jj_gen;
        break label_3;
      }
      ProcedureDecl();
    }
  }

  static final public void VarTypeDecl() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case CONST:{
      jj_consume_token(CONST);
      label_4:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case IDENT:{
          ;
          break;
          }
        default:
          jj_la1[6] = jj_gen;
          break label_4;
        }
        ConstDecl();
        jj_consume_token(54);
      }
      break;
      }
    case TYPE:{
      jj_consume_token(TYPE);
      label_5:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case IDENT:{
          ;
          break;
          }
        default:
          jj_la1[7] = jj_gen;
          break label_5;
        }
        TypeDecl();
        jj_consume_token(54);
      }
      break;
      }
    case VAR:{
      jj_consume_token(VAR);
      label_6:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case IDENT:{
          ;
          break;
          }
        default:
          jj_la1[8] = jj_gen;
          break label_6;
        }
        VarDecl();
        jj_consume_token(54);
      }
      break;
      }
    default:
      jj_la1[9] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void ConstDecl() throws ParseException {
    IdentDef();
    jj_consume_token(58);
    ConstExpr();
  }

  static final public void TypeDecl() throws ParseException {
    IdentDef();
    jj_consume_token(58);
    Type();
  }

  static final public void VarDecl() throws ParseException {
    IdentList();
    jj_consume_token(59);
    Type();
  }

  static final public void ProcedureDecl() throws ParseException {
    jj_consume_token(PROCEDURE);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 60:{
      ForwardDecl();
      break;
      }
    case IDENT:
    case 61:{
      ProcDecl();
      break;
      }
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(54);
  }

  static final public void ProcDecl() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 61:{
      Receiver();
      break;
      }
    default:
      jj_la1[11] = jj_gen;
      ;
    }
    IdentDef();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 61:{
      FormalPars();
      break;
      }
    default:
      jj_la1[12] = jj_gen;
      ;
    }
    jj_consume_token(54);
    DeclSeq();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case BEGIN:{
      jj_consume_token(BEGIN);
      StatementSeq();
      break;
      }
    default:
      jj_la1[13] = jj_gen;
      ;
    }
    jj_consume_token(END);
    jj_consume_token(IDENT);
  }

  static final public void ForwardDecl() throws ParseException {
    jj_consume_token(60);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 61:{
      Receiver();
      break;
      }
    default:
      jj_la1[14] = jj_gen;
      ;
    }
    IdentDef();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 61:{
      FormalPars();
      break;
      }
    default:
      jj_la1[15] = jj_gen;
      ;
    }
  }

  static final public void FormalPars() throws ParseException {
    jj_consume_token(61);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case VAR:
    case IDENT:{
      FPSection();
      label_7:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case 54:{
          ;
          break;
          }
        default:
          jj_la1[16] = jj_gen;
          break label_7;
        }
        jj_consume_token(54);
        FPSection();
      }
      break;
      }
    default:
      jj_la1[17] = jj_gen;
      ;
    }
    jj_consume_token(62);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 59:{
      jj_consume_token(59);
      Qualident();
      break;
      }
    default:
      jj_la1[18] = jj_gen;
      ;
    }
  }

  static final public void FPSection() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case VAR:{
      jj_consume_token(VAR);
      break;
      }
    default:
      jj_la1[19] = jj_gen;
      ;
    }
    jj_consume_token(IDENT);
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 56:{
        ;
        break;
        }
      default:
        jj_la1[20] = jj_gen;
        break label_8;
      }
      jj_consume_token(56);
      jj_consume_token(IDENT);
    }
    jj_consume_token(59);
    Type();
  }

  static final public void Receiver() throws ParseException {
    jj_consume_token(61);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case VAR:{
      jj_consume_token(VAR);
      break;
      }
    default:
      jj_la1[21] = jj_gen;
      ;
    }
    jj_consume_token(IDENT);
    jj_consume_token(59);
    jj_consume_token(IDENT);
    jj_consume_token(62);
  }

  static final public void Type() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case IDENT:{
      Qualident();
      break;
      }
    case ARRAY:{
      jj_consume_token(ARRAY);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case NIL:
      case INTEGER:
      case REAL:
      case IDENT:
      case CHARACTER:
      case STRING:
      case 61:
      case 64:
      case 65:
      case 66:
      case 67:{
        ConstExpr();
        label_9:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
          case 56:{
            ;
            break;
            }
          default:
            jj_la1[22] = jj_gen;
            break label_9;
          }
          jj_consume_token(56);
          ConstExpr();
        }
        break;
        }
      default:
        jj_la1[23] = jj_gen;
        ;
      }
      jj_consume_token(OF);
      Type();
      break;
      }
    case RECORD:{
      jj_consume_token(RECORD);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 61:{
        jj_consume_token(61);
        Qualident();
        jj_consume_token(62);
        break;
        }
      default:
        jj_la1[24] = jj_gen;
        ;
      }
      FieldList();
      label_10:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case 54:{
          ;
          break;
          }
        default:
          jj_la1[25] = jj_gen;
          break label_10;
        }
        jj_consume_token(54);
        FieldList();
      }
      jj_consume_token(END);
      break;
      }
    case POINTER:{
      jj_consume_token(POINTER);
      jj_consume_token(TO);
      Type();
      break;
      }
    case PROCEDURE:{
      jj_consume_token(PROCEDURE);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 61:{
        FormalPars();
        break;
        }
      default:
        jj_la1[26] = jj_gen;
        ;
      }
      break;
      }
    default:
      jj_la1[27] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void FieldList() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case IDENT:{
      IdentList();
      jj_consume_token(59);
      Type();
      break;
      }
    default:
      jj_la1[28] = jj_gen;
      ;
    }
  }

  static final public void StatementSeq() throws ParseException {
    optStatement();
    label_11:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 54:{
        ;
        break;
        }
      default:
        jj_la1[29] = jj_gen;
        break label_11;
      }
      jj_consume_token(54);
      optStatement();
    }
  }

  static final public void optStatement() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case CASE:
    case EXIT:
    case FOR:
    case IF:
    case LOOP:
    case REPEAT:
    case RETURN:
    case WHILE:
    case WITH:
    case IDENT:{
      Statement();
      break;
      }
    default:
      jj_la1[30] = jj_gen;
      ;
    }
  }

  static final public void Statement() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case IDENT:{
      Designator();
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 57:{
        jj_consume_token(57);
        Expr();
        break;
        }
      default:
        jj_la1[31] = jj_gen;
        Arguments();
      }
      break;
      }
    case IF:{
      jj_consume_token(IF);
      Expr();
      jj_consume_token(THEN);
      StatementSeq();
      label_12:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case ELSIF:{
          ;
          break;
          }
        default:
          jj_la1[32] = jj_gen;
          break label_12;
        }
        jj_consume_token(ELSIF);
        Expr();
        jj_consume_token(THEN);
        StatementSeq();
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case ELSE:{
        jj_consume_token(ELSE);
        StatementSeq();
        break;
        }
      default:
        jj_la1[33] = jj_gen;
        ;
      }
      jj_consume_token(END);
      break;
      }
    case CASE:{
      jj_consume_token(CASE);
      Expr();
      jj_consume_token(OF);
      Case();
      label_13:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case 63:{
          ;
          break;
          }
        default:
          jj_la1[34] = jj_gen;
          break label_13;
        }
        jj_consume_token(63);
        Case();
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case ELSE:{
        jj_consume_token(ELSE);
        StatementSeq();
        break;
        }
      default:
        jj_la1[35] = jj_gen;
        ;
      }
      jj_consume_token(END);
      break;
      }
    case WHILE:{
      jj_consume_token(WHILE);
      Expr();
      jj_consume_token(DO);
      StatementSeq();
      jj_consume_token(END);
      break;
      }
    case REPEAT:{
      jj_consume_token(REPEAT);
      StatementSeq();
      jj_consume_token(UNTIL);
      Expr();
      break;
      }
    case FOR:{
      jj_consume_token(FOR);
      jj_consume_token(IDENT);
      jj_consume_token(57);
      Expr();
      jj_consume_token(TO);
      Expr();
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case BY:{
        jj_consume_token(BY);
        ConstExpr();
        break;
        }
      default:
        jj_la1[36] = jj_gen;
        ;
      }
      jj_consume_token(DO);
      StatementSeq();
      jj_consume_token(END);
      break;
      }
    case LOOP:{
      jj_consume_token(LOOP);
      StatementSeq();
      jj_consume_token(END);
      break;
      }
    case WITH:{
      jj_consume_token(WITH);
      Guard();
      jj_consume_token(DO);
      StatementSeq();
      label_14:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case 63:{
          ;
          break;
          }
        default:
          jj_la1[37] = jj_gen;
          break label_14;
        }
        jj_consume_token(63);
        Guard();
        jj_consume_token(DO);
        StatementSeq();
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case ELSE:{
        jj_consume_token(ELSE);
        StatementSeq();
        break;
        }
      default:
        jj_la1[38] = jj_gen;
        ;
      }
      jj_consume_token(END);
      break;
      }
    case EXIT:{
      jj_consume_token(EXIT);
      break;
      }
    case RETURN:{
      jj_consume_token(RETURN);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case NIL:
      case INTEGER:
      case REAL:
      case IDENT:
      case CHARACTER:
      case STRING:
      case 61:
      case 64:
      case 65:
      case 66:
      case 67:{
        Expr();
        break;
        }
      default:
        jj_la1[39] = jj_gen;
        ;
      }
      break;
      }
    default:
      jj_la1[40] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Case() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case NIL:
    case INTEGER:
    case REAL:
    case IDENT:
    case CHARACTER:
    case STRING:
    case 61:
    case 64:
    case 65:
    case 66:
    case 67:{
      CaseLabels();
      label_15:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case 56:{
          ;
          break;
          }
        default:
          jj_la1[41] = jj_gen;
          break label_15;
        }
        jj_consume_token(56);
        CaseLabels();
      }
      jj_consume_token(59);
      StatementSeq();
      break;
      }
    default:
      jj_la1[42] = jj_gen;
      ;
    }
  }

  static final public void CaseLabels() throws ParseException {
    ConstExpr();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case DOTDOT:{
      jj_consume_token(DOTDOT);
      ConstExpr();
      break;
      }
    default:
      jj_la1[43] = jj_gen;
      ;
    }
  }

  static final public void Guard() throws ParseException {
    Qualident();
    jj_consume_token(59);
    Qualident();
  }

  static final public void ConstExpr() throws ParseException {
    Expr();
  }

  static final public void Expr() throws ParseException {
    SimpleExpr();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case IN:
    case IS:
    case 58:
    case 69:
    case 70:
    case 71:
    case 72:
    case 73:{
      Relation();
      SimpleExpr();
      break;
      }
    default:
      jj_la1[44] = jj_gen;
      ;
    }
  }

  static final public void SimpleExpr() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 64:
    case 65:{
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 64:{
        jj_consume_token(64);
        break;
        }
      case 65:{
        jj_consume_token(65);
        break;
        }
      default:
        jj_la1[45] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
      }
    default:
      jj_la1[46] = jj_gen;
      ;
    }
    Term();
    label_16:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case OR:
      case 64:
      case 65:{
        ;
        break;
        }
      default:
        jj_la1[47] = jj_gen;
        break label_16;
      }
      AddOp();
      Term();
    }
  }

  static final public void Term() throws ParseException {
    Factor();
    label_17:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case DIV:
      case MOD:
      case 74:
      case 75:
      case 76:{
        ;
        break;
        }
      default:
        jj_la1[48] = jj_gen;
        break label_17;
      }
      MulOp();
      Factor();
    }
  }

  static final public void Factor() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case IDENT:{
      Designator();
      Arguments();
      break;
      }
    case INTEGER:
    case REAL:{
      Number();
      break;
      }
    case CHARACTER:{
      jj_consume_token(CHARACTER);
      break;
      }
    case STRING:{
      jj_consume_token(STRING);
      break;
      }
    case NIL:{
      jj_consume_token(NIL);
      break;
      }
    case 67:{
      Set();
      break;
      }
    case 61:{
      jj_consume_token(61);
      Expr();
      jj_consume_token(62);
      break;
      }
    case 66:{
      jj_consume_token(66);
      Factor();
      break;
      }
    default:
      jj_la1[49] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Set() throws ParseException {
    jj_consume_token(67);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case NIL:
    case INTEGER:
    case REAL:
    case IDENT:
    case CHARACTER:
    case STRING:
    case 61:
    case 64:
    case 65:
    case 66:
    case 67:{
      Element();
      label_18:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case 56:{
          ;
          break;
          }
        default:
          jj_la1[50] = jj_gen;
          break label_18;
        }
        jj_consume_token(56);
        Element();
      }
      break;
      }
    default:
      jj_la1[51] = jj_gen;
      ;
    }
    jj_consume_token(68);
  }

  static final public void Element() throws ParseException {
    Expr();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case DOTDOT:{
      jj_consume_token(DOTDOT);
      Expr();
      break;
      }
    default:
      jj_la1[52] = jj_gen;
      ;
    }
  }

  static final public void Relation() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 58:{
      jj_consume_token(58);
      break;
      }
    case 69:{
      jj_consume_token(69);
      break;
      }
    case 70:{
      jj_consume_token(70);
      break;
      }
    case 71:{
      jj_consume_token(71);
      break;
      }
    case 72:{
      jj_consume_token(72);
      break;
      }
    case 73:{
      jj_consume_token(73);
      break;
      }
    case IN:{
      jj_consume_token(IN);
      break;
      }
    case IS:{
      jj_consume_token(IS);
      break;
      }
    default:
      jj_la1[53] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void AddOp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 64:{
      jj_consume_token(64);
      break;
      }
    case 65:{
      jj_consume_token(65);
      break;
      }
    case OR:{
      jj_consume_token(OR);
      break;
      }
    default:
      jj_la1[54] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void MulOp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 74:{
      jj_consume_token(74);
      break;
      }
    case 75:{
      jj_consume_token(75);
      break;
      }
    case DIV:{
      jj_consume_token(DIV);
      break;
      }
    case MOD:{
      jj_consume_token(MOD);
      break;
      }
    case 76:{
      jj_consume_token(76);
      break;
      }
    default:
      jj_la1[55] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/* NB: Because Arguments() always appears after Designator(), there
   * will be a conflict if we get "(" Qualident() ")" - do we consume
   * this as part of the Designator(), or leave it for the Arguments()
   * The disambiguation in Designator() chooses the former, so the
   * semantic phase will have to disentangle this for function calls
   * with one (qualified) identifier as an argument.
   */
  static final public
void Arguments() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 61:{
      jj_consume_token(61);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case NIL:
      case INTEGER:
      case REAL:
      case IDENT:
      case CHARACTER:
      case STRING:
      case 61:
      case 64:
      case 65:
      case 66:
      case 67:{
        ExprList();
        break;
        }
      default:
        jj_la1[56] = jj_gen;
        ;
      }
      jj_consume_token(62);
      break;
      }
    default:
      jj_la1[57] = jj_gen;
      ;
    }
  }

  static final public void Designator() throws ParseException {
    jj_consume_token(IDENT);
    label_19:
    while (true) {
      if (jj_2_1(2147483647)) {
        ;
      } else {
        break label_19;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 55:{
        jj_consume_token(55);
        jj_consume_token(IDENT);
        break;
        }
      case 77:{
        jj_consume_token(77);
        ExprList();
        jj_consume_token(78);
        break;
        }
      case 60:{
        jj_consume_token(60);
        break;
        }
      case 61:{
        jj_consume_token(61);
        Qualident();
        jj_consume_token(62);
        break;
        }
      default:
        jj_la1[58] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  static final public void ExprList() throws ParseException {
    Expr();
    label_20:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 56:{
        ;
        break;
        }
      default:
        jj_la1[59] = jj_gen;
        break label_20;
      }
      jj_consume_token(56);
      Expr();
    }
  }

  static final public void IdentList() throws ParseException {
    IdentDef();
    label_21:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 56:{
        ;
        break;
        }
      default:
        jj_la1[60] = jj_gen;
        break label_21;
      }
      jj_consume_token(56);
      IdentDef();
    }
  }

  static final public void Qualident() throws ParseException {
    jj_consume_token(IDENT);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 55:{
      jj_consume_token(55);
      jj_consume_token(IDENT);
      break;
      }
    default:
      jj_la1[61] = jj_gen;
      ;
    }
  }

  static final public void IdentDef() throws ParseException {
    jj_consume_token(IDENT);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 65:
    case 74:{
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 74:{
        jj_consume_token(74);
        break;
        }
      case 65:{
        jj_consume_token(65);
        break;
        }
      default:
        jj_la1[62] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
      }
    default:
      jj_la1[63] = jj_gen;
      ;
    }
  }

  static final public void Number() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case INTEGER:{
      jj_consume_token(INTEGER);
      break;
      }
    case REAL:{
      jj_consume_token(REAL);
      break;
      }
    default:
      jj_la1[64] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static private boolean jj_2_1(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  static private boolean jj_3_1()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(55)) {
    jj_scanpos = xsp;
    if (jj_scan_token(77)) {
    jj_scanpos = xsp;
    if (jj_scan_token(60)) {
    jj_scanpos = xsp;
    if (jj_3R_22()) return true;
    }
    }
    }
    return false;
  }

  static private boolean jj_3R_23()
 {
    if (jj_scan_token(IDENT)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_24()) jj_scanpos = xsp;
    return false;
  }

  static private boolean jj_3R_24()
 {
    if (jj_scan_token(55)) return true;
    if (jj_scan_token(IDENT)) return true;
    return false;
  }

  static private boolean jj_3R_22()
 {
    if (jj_scan_token(61)) return true;
    if (jj_3R_23()) return true;
    if (jj_scan_token(62)) return true;
    return false;
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public OberonParserTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private Token jj_scanpos, jj_lastpos;
  static private int jj_la;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[65];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static private int[] jj_la1_2;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
      jj_la1_init_2();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x400000,0x400,0x0,0x0,0x2000,0x0,0x0,0x0,0x0,0x2000,0x0,0x0,0x0,0x400,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x10000000,0x0,0x0,0x0,0x80000200,0x0,0x0,0x2381000,0x0,0x20000,0x10000,0x0,0x10000,0x800,0x0,0x10000,0x10000000,0x2381000,0x0,0x10000000,0x0,0x1800000,0x0,0x0,0x40000000,0x4004000,0x10000000,0x0,0x10000000,0x0,0x1800000,0x40000000,0x4004000,0x10000000,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x1000000,0x2000000,0x140,0x1,0x80000,0x80000,0x80000,0x140,0x30080000,0x20000000,0x20000000,0x0,0x20000000,0x20000000,0x400000,0x80100,0x8000000,0x100,0x1000000,0x100,0x1000000,0x203b0000,0x20000000,0x400000,0x20000000,0x80003,0x80000,0x400000,0x8060c,0x2000000,0x0,0x0,0x80000000,0x0,0x0,0x80000000,0x0,0x203b0000,0x8060c,0x1000000,0x203b0000,0x800,0x4000000,0x0,0x0,0x0,0x0,0x203b0000,0x1000000,0x203b0000,0x800,0x4000000,0x0,0x0,0x203b0000,0x20000000,0x30800000,0x1000000,0x1000000,0x800000,0x0,0x0,0x30000,};
   }
   private static void jj_la1_init_2() {
      jj_la1_2 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0xf,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0xf,0x0,0x0,0xf,0x0,0x3e0,0x3,0x3,0x3,0x1c00,0xc,0x0,0xf,0x0,0x3e0,0x3,0x1c00,0xf,0x0,0x2000,0x0,0x0,0x0,0x402,0x402,0x0,};
   }
  static final private JJCalls[] jj_2_rtns = new JJCalls[1];
  static private boolean jj_rescan = false;
  static private int jj_gc = 0;

  /** Constructor with InputStream. */
  public OberonParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public OberonParser(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new OberonParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 65; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 65; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public OberonParser(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new OberonParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 65; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 65; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public OberonParser(OberonParserTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 65; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(OberonParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 65; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  @SuppressWarnings("serial")
  static private final class LookaheadSuccess extends java.lang.Error { }
  static final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  static private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk_f() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;
  static private int[] jj_lasttokens = new int[100];
  static private int jj_endpos;

  static private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[79];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 65; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
          if ((jj_la1_2[i] & (1<<j)) != 0) {
            la1tokens[64+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 79; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

  static private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 1; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  static private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
