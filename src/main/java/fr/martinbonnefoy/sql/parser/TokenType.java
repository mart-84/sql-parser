package fr.martinbonnefoy.sql.parser;

/**
 * Available types of tokens.<br>
 * Provides the list of keywords, symbols, and more
 */
public enum TokenType {

	// Keywords
	SELECT, FROM, WHERE, DISTINCT, AS, AND, OR,

	// Symbols
	COMMA, DOT, STAR, SEMICOLON, OPEN_PAREN, CLOSE_PAREN,

	// Operators
	COMPARISON_OP,

	// Others
	IDENTIFIER, NUMERIC_LIT, STRING_LIT;

}
