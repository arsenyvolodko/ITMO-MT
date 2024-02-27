grammar Grammar;

@header {
import java.util.*;
}

grName returns[String grammarName]
: 'grammar' Var ';' { $grammarName = $Var.text;}
;

abstractGrammar returns[GrammarAdapter grammar] @init {
    GrammarAdapter grammar = new GrammarAdapter();
    $grammar = grammar;
}
: grName rules[grammar] {
    $grammar.setGrammarName($grName.grammarName);
} EOF;

rules[GrammarAdapter grammar]
    : (terminalRule[grammar]
    | nonTerminalRule[grammar])*;

terminalRule[GrammarAdapter grammar]
: Var ':' REGEXP ';' { $grammar.addToken($Var.text, $REGEXP.text); }
;

nonTerminalRule[GrammarAdapter grammar]
: Var heritableAttr attr { RuleTransition ruleTransition = new RuleTransition($Var.text, $attr.text, $heritableAttr.text);}
    ':' rule[grammar, ruleTransition]
    ('|' rule[grammar, ruleTransition])* ';'
;

rule[GrammarAdapter grammar, RuleTransition name] @init {
    List<Eval> evals = new ArrayList<>();
}
: (eval { evals.add($eval.evl); }) + { $grammar.addRules($name, new Rule(evals)); }
| 'ε' CODE? { $grammar.addRules($name, new Rule(List.of(new Eval(List.of(), $CODE.text)))); }
;

eval returns [Eval evl] @init {
   List<UseRule> useRules = new ArrayList<>();
}
 : (Var IMPL_ATTR? { useRules.add(new UseRule($Var.text, $IMPL_ATTR.text)); })+
    CODE { $evl = new Eval(useRules, $CODE.text); }
    ;
attr: DEF_ATTR;
heritableAttr: IMPL_ATTR;


Var: [a-zA-Z_] ([0-9] | [a-zA-Z_])*;
Number: ([0-9]+ | [0-9]+ '.' [0-9]*);
Whitespace: [ \n]+  -> skip;
NewLine: [\n\r]+ -> skip;
REGEXP: '"'.*?'"';
RETURNS: '->';
CODE: '{' .*? '}';
DEF_ATTR: '[' .*? ']';
IMPL_ATTR: '(' .*? ')';

New_line: [\n\r]+ -> skip;
BlockComment: '/*' .*? '*/' -> skip;
LineComment: '//' ~ [\r\n]* -> skip;