package fr.martinbonnefoy.sql.parser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TokenFactoryTest {

	@Test
	void testCreateToken() {
		Token token = TokenFactory.createToken(TokenType.SELECT, "SELECT");

		assertNotNull(token);
		assertEquals(TokenType.SELECT, token.getType());
		assertEquals("SELECT", token.getValue());
	}

	@Test
	void testCreateSelectToken() {
		Token token = TokenFactory.createSelectToken();

		assertNotNull(token);
		assertEquals(TokenType.SELECT, token.getType());
		assertEquals("SELECT", token.getValue());
	}

	@Test
	void testCreateFromToken() {
		Token token = TokenFactory.createFromToken();

		assertNotNull(token);
		assertEquals(TokenType.FROM, token.getType());
		assertEquals("FROM", token.getValue());
	}

	@Test
	void testCreateWhereToken() {
		Token token = TokenFactory.createWhereToken();

		assertNotNull(token);
		assertEquals(TokenType.WHERE, token.getType());
		assertEquals("WHERE", token.getValue());
	}

	@Test
	void testCreateDistinctToken() {
		Token token = TokenFactory.createDistinctToken();

		assertNotNull(token);
		assertEquals(TokenType.DISTINCT, token.getType());
		assertEquals("DISTINCT", token.getValue());
	}

	@Test
	void testCreateAsToken() {
		Token token = TokenFactory.createAsToken();

		assertNotNull(token);
		assertEquals(TokenType.AS, token.getType());
		assertEquals("AS", token.getValue());
	}

	@Test
	void testCreateAndToken() {
		Token token = TokenFactory.createAndToken();

		assertNotNull(token);
		assertEquals(TokenType.AND, token.getType());
		assertEquals("AND", token.getValue());
	}

	@Test
	void testCreateOrToken() {
		Token token = TokenFactory.createOrToken();

		assertNotNull(token);
		assertEquals(TokenType.OR, token.getType());
		assertEquals("OR", token.getValue());
	}

	@Test
	void testCreateCommaToken() {
		Token token = TokenFactory.createCommaToken();

		assertNotNull(token);
		assertEquals(TokenType.COMMA, token.getType());
		assertEquals(",", token.getValue());
	}

	@Test
	void testCreateDotToken() {
		Token token = TokenFactory.createDotToken();

		assertNotNull(token);
		assertEquals(TokenType.DOT, token.getType());
		assertEquals(".", token.getValue());
	}

	@Test
	void testCreateStarToken() {
		Token token = TokenFactory.createStarToken();

		assertNotNull(token);
		assertEquals(TokenType.STAR, token.getType());
		assertEquals("*", token.getValue());
	}

	@Test
	void testCreateSemicolonToken() {
		Token token = TokenFactory.createSemicolonToken();

		assertNotNull(token);
		assertEquals(TokenType.SEMICOLON, token.getType());
		assertEquals(";", token.getValue());
	}

	@Test
	void testCreateOpenParenToken() {
		Token token = TokenFactory.createOpenParenToken();

		assertNotNull(token);
		assertEquals(TokenType.OPEN_PAREN, token.getType());
		assertEquals("(", token.getValue());
	}

	@Test
	void testCreateCloseParenToken() {
		Token token = TokenFactory.createCloseParenToken();

		assertNotNull(token);
		assertEquals(TokenType.CLOSE_PAREN, token.getType());
		assertEquals(")", token.getValue());
	}

	@Test
	void testCreateComparisonOpToken() {
		Token token = TokenFactory.createComparisonOpToken("=");

		assertNotNull(token);
		assertEquals(TokenType.COMPARISON_OP, token.getType());
		assertEquals("=", token.getValue());
	}

	@Test
	void testCreateIdentifierToken() {
		Token token = TokenFactory.createIdentifierToken("identifier");

		assertNotNull(token);
		assertEquals(TokenType.IDENTIFIER, token.getType());
		assertEquals("identifier", token.getValue());
	}

	@Test
	void testCreateNumericLitToken() {
		Token token = TokenFactory.createNumericLitToken("123");

		assertNotNull(token);
		assertEquals(TokenType.NUMERIC_LIT, token.getType());
		assertEquals("123", token.getValue());
	}

	@Test
	void testCreateStringLitToken() {
		Token token = TokenFactory.createStringLitToken("string");

		assertNotNull(token);
		assertEquals(TokenType.STRING_LIT, token.getType());
		assertEquals("string", token.getValue());
	}

}