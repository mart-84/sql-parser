package fr.martinbonnefoy.sql.parser;

/**
 * The TokenFactory class provides static methods to create different types of tokens.
 */
public class TokenFactory {

	private TokenFactory() {
		// Prevents instantiation
	}

	/**
	 * Creates a token with the specified type and value.
	 *
	 * @param type  the type of the token
	 * @param value the value of the token
	 * @return the created token
	 */
	public static Token createToken(TokenType type, String value) {
		return new Token(type, value);
	}

	/**
	 * Creates a SELECT token.
	 *
	 * @return the created SELECT token
	 */
	public static Token createSelectToken() {
		return new Token(TokenType.SELECT, "SELECT");
	}

	/**
	 * Creates a FROM token.
	 *
	 * @return the created FROM token
	 */
	public static Token createFromToken() {
		return new Token(TokenType.FROM, "FROM");
	}

	/**
	 * Creates a WHERE token.
	 *
	 * @return the created WHERE token
	 */
	public static Token createWhereToken() {
		return new Token(TokenType.WHERE, "WHERE");
	}

	/**
	 * Creates a DISTINCT token.
	 *
	 * @return the created DISTINCT token
	 */
	public static Token createDistinctToken() {
		return new Token(TokenType.DISTINCT, "DISTINCT");
	}

	/**
	 * Creates an AS token.
	 *
	 * @return the created AS token
	 */
	public static Token createAsToken() {
		return new Token(TokenType.AS, "AS");
	}

	/**
	 * Creates an AND token.
	 *
	 * @return the created AND token
	 */
	public static Token createAndToken() {
		return new Token(TokenType.AND, "AND");
	}

	/**
	 * Creates an OR token.
	 *
	 * @return the created OR token
	 */
	public static Token createOrToken() {
		return new Token(TokenType.OR, "OR");
	}

	/**
	 * Creates a COMMA token.
	 *
	 * @return the created COMMA token
	 */
	public static Token createCommaToken() {
		return new Token(TokenType.COMMA, ",");
	}

	/**
	 * Creates a DOT token.
	 *
	 * @return the created DOT token
	 */
	public static Token createDotToken() {
		return new Token(TokenType.DOT, ".");
	}

	/**
	 * Creates a STAR token.
	 *
	 * @return the created STAR token
	 */
	public static Token createStarToken() {
		return new Token(TokenType.STAR, "*");
	}

	/**
	 * Creates a SEMICOLON token.
	 *
	 * @return the created SEMICOLON token
	 */
	public static Token createSemicolonToken() {
		return new Token(TokenType.SEMICOLON, ";");
	}

	/**
	 * Creates an OPEN_PAREN token.
	 *
	 * @return the created OPEN_PAREN token
	 */
	public static Token createOpenParenToken() {
		return new Token(TokenType.OPEN_PAREN, "(");
	}

	/**
	 * Creates a CLOSE_PAREN token.
	 *
	 * @return the created CLOSE_PAREN token
	 */
	public static Token createCloseParenToken() {
		return new Token(TokenType.CLOSE_PAREN, ")");
	}

	/**
	 * Creates a COMPARISON_OP token with the specified value.
	 *
	 * @param value the value of the COMPARISON_OP token
	 * @return the created COMPARISON_OP token
	 */
	public static Token createComparisonOpToken(String value) {
		return new Token(TokenType.COMPARISON_OP, value);
	}

	/**
	 * Creates an IDENTIFIER token with the specified value.
	 *
	 * @param value the value of the IDENTIFIER token
	 * @return the created IDENTIFIER token
	 */
	public static Token createIdentifierToken(String value) {
		return new Token(TokenType.IDENTIFIER, value);
	}

	/**
	 * Creates a NUMERIC_LIT token with the specified value.
	 *
	 * @param value the value of the NUMERIC_LIT token
	 * @return the created NUMERIC_LIT token
	 */
	public static Token createNumericLitToken(String value) {
		return new Token(TokenType.NUMERIC_LIT, value);
	}

	/**
	 * Creates a STRING_LIT token with the specified value.
	 *
	 * @param value the value of the STRING_LIT token
	 * @return the created STRING_LIT token
	 */
	public static Token createStringLitToken(String value) {
		return new Token(TokenType.STRING_LIT, value);
	}
}
