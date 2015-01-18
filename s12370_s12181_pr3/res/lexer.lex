package parser;
  
import java_cup.runtime.Symbol;

import static parser.Symbols.*;
 


%%
%{ 
        private Symbol createToken(int id) {
                return new Symbol(id, yyline, yycolumn);
        }
        private Symbol createToken(int id, Object o) {
                return new Symbol(id, yyline, yycolumn, o);
        }
%}
 
%public
%class Lexer 
%cup
%line 
%column
%char
%eofval{
        return createToken(EOF);
%eofval}

INTEGER = [0-9]+
BOOLEAN = true|false
IDENTIFIER = [_a-zA-Z][0-9a-zA-Z]*
DOUBLE = [0-9]+\.[0-9]+
STRING = [\"][^\"]*[\"]
CHAR = [\'][^\"][\']
LineTerminator = \r|\n|\r\n 
WHITESPACE = {LineTerminator} | [ \t\f]
  
%% 
 
<YYINITIAL> {
        "+"                                             { return createToken(PLUS                               ); }
        "-"                                             { return createToken(MINUS                              ); }
        "*"                                             { return createToken(MULTIPLY                   ); }
        "/"                                             { return createToken(DIVIDE                             ); }
        "%"                     { return createToken(MODULO             ); }
        
    "=="                    { return createToken(EQUALS             ); }
    "!="                    { return createToken(NOT_EQUALS         ); }
    ">"                     { return createToken(MORE               ); }
    ">="                    { return createToken(MORE_OR_EQUAL      ); }
    "<="                    { return createToken(LESS_OR_EQUAL      ); }
    "<"                     { return createToken(LESS               ); }
        
    "."                     { return createToken(DOT                ); }
    ","                     { return createToken(COMMA              ); }
        
    "IN"|"In"|"in"          { return createToken(IN                 ); }
        
    "WHERE"| "Where"|"where"    { return createToken(WHERE              ); }
    "EXISTS"|"Exists"|"exists"  { return createToken(EXISTS             ); }
        
    "OR"|"Or"  |"or" |"\|\|"   { return createToken(OR                 ); }
    "AND"|"And" |"and"|"&&"    { return createToken(AND                ); }
    "XOR" |"Xor" |"xor"|"\^\^" { return createToken(XOR                ); }
    "NOT" |"Not" |"not"|"!"    { return createToken(NOT                ); }
        
    "MINUS"|"Minus"|"minus"                { return createToken(MINUS_FUNCTION     ); }
    "INTERSECT"|"Intersect"|"intersect"    { return createToken(INTERSECT          ); }
        
    "SUM"|"Sum"|"sum"          { return createToken(SUM                ); }
    "AVG"|"Avg"|"avg"          { return createToken(AVG                ); }
    "MIN"|"Min"|"min"          { return createToken(MIN                ); }
    "MAX"|"Max"|"max"          { return createToken(MAX                ); }
        
    "COUNT"| "Count"|"count"   { return createToken(COUNT              ); }
    "UNIQUE"|"Unique"|"unique" { return createToken(UNIQUE             ); }
    "UNION"|"Union" |"union"   { return createToken(UNION              ); }
        
    "AS"|"As"|"as"             { return createToken(AS                 ); }
    "GROUPAS" |"GroupAs" |
    "groupas" |"GROUP AS"|
    "Group As"|"Group as"|
    "group as"                 { return createToken(GROUP_AS           ); }
    "JOIN"|"Join"|"join"       { return createToken(JOIN               ); }
    "ALL"|"All"|"all"          { return createToken(FORALL             ); }
    "ANY"|"any"|"Any"          { return createToken(FORANY             ); }
        
    "BAG"|"Bag"    |"bag"      { return createToken(BAG                ); }
    "STRUCT"|"Struct"|"struct" { return createToken(STRUCT             ); }
        "("                                              { return createToken(LEFT_ROUND_BRACKET   ); }
        ")"                                              { return createToken(RIGHT_ROUND_BRACKET  ); } 
         
        {WHITESPACE} { }
        {STRING} {return createToken(STRING_LITERAL, yytext().substring(1,yytext().length()-1)) ; }
        {INTEGER} {
                int val;
                try {
                        val = Integer.parseInt(yytext());
                }
                catch (Exception e) {
                        throw new RuntimeException(e.getMessage());
                }
                return createToken(INTEGER_LITERAL, new Integer(val));
        }
        {DOUBLE} {
                double val;
                try {
                        val = Double.parseDouble(yytext());
                }
                catch (Exception e) {
                        throw new RuntimeException(e.getMessage());
                }
                return createToken(DOUBLE_LITERAL, new Double(val));
        }
        {BOOLEAN} {
                boolean val;
                try {
                        val = Boolean.parseBoolean(yytext());
                }
                catch (Exception e) {
                        throw new RuntimeException(e.getMessage());
                }
                return createToken(BOOLEAN_LITERAL, new Boolean(val));
        }
        {IDENTIFIER} {
        return createToken(IDENTIFIER, yytext());
    }  
}