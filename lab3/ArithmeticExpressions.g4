grammar ArithmeticExpressions;
s : equation* EOF;

equation: VARIABLE equls expression SEMICOLON;

expression
    : term
    | expression addSubOp term;

term
    : unaryMinus? factor
    | term mullDivOp factor;

factor
    : atom
    | LPAREN expression RPAREN;

unaryMinus: MINUS;

addSubOp: PLUS | MINUS;

mullDivOp: TIMES | DIV;

atom: NUMBER | VARIABLE;

equls: EQ;

VARIABLE: VALID_ID_START VALID_ID_CHAR*;

SEMICOLON: ';';

fragment VALID_ID_START: 'a' .. 'z' | 'A' .. 'Z' | '_';

fragment VALID_ID_CHAR: VALID_ID_START | '0' .. '9';

NUMBER: UNSIGNED_INTEGER;

fragment UNSIGNED_INTEGER: ('0' .. '9')+;

LPAREN: '(';

RPAREN: ')';

PLUS: '+';

MINUS: '-';

TIMES: '*';

DIV: '/';

EQ: '=';

WS: [ \r\n\t] + -> skip;