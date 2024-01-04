package fr.martinbonnefoy.sql.parser;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import fr.martinbonnefoy.sql.parser.exceptions.InvalidTokenException;

class LexerTest {

	@Test
	void testConstructorWithValidQuery() {
		Lexer lexer = new Lexer("test");

		assertNotNull(lexer.getQuery());
		assertEquals("test", lexer.getQuery());
	}

	@Test
	void testConstructorWithNullQuery() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> new Lexer(null));

		String expectedMessage = "The query must not be null";
		String actualMessage = exception.getMessage();
		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	void testGetQueryShouldReturnCorrectValue() {
		Lexer lexer = new Lexer("query");

		assertEquals("query", lexer.getQuery());
	}

	@Test
	void testSetQueryWithValidQuery() {
		Lexer lexer = new Lexer("query");

		lexer.setQuery("new_query");

		assertEquals("new_query", lexer.getQuery());
	}

	@Test
	void testSetQueryWithNullQuery() {
		Lexer lexer = new Lexer("query");

		Exception exception = assertThrows(IllegalArgumentException.class, () -> lexer.setQuery(null));

		String expectedMessage = "The query must not be null";
		String actualMessage = exception.getMessage();
		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	void testGetTokensWithoutTokenization() {
		Lexer lexer = new Lexer("query");

		List<Token> expected = new ArrayList<>();
		List<Token> actual = lexer.getTokens();
		assertEquals(expected, actual);
	}

	@Test
	void testTokenizeWithValidSimpleQuery() throws InvalidTokenException {
		Lexer lexer = new Lexer("SELECT * FROM table;");

		lexer.tokenize();

		List<Token> expected = new ArrayList<>();
		expected.add(TokenFactory.createSelectToken());
		expected.add(TokenFactory.createStarToken());
		expected.add(TokenFactory.createFromToken());
		expected.add(TokenFactory.createIdentifierToken("table"));
		expected.add(TokenFactory.createSemicolonToken());
		List<Token> actual = lexer.getTokens();
		assertEquals(expected, actual);
	}

	@Test
	void testTokenizeWithValidComplexQuery() throws InvalidTokenException {
		Lexer lexer = new Lexer("SELECT DISTINCT foo.bar AS something, test.*, anything AS one_more_thing\r\n"
				+ "FROM IIIII AS a1, kljm a2\r\nWHERE (a1.test = 'aa' AND a1.foo = 1) OR a1.foo > 10;");

		lexer.tokenize();

		List<Token> expected = Arrays.asList(TokenFactory.createSelectToken(), TokenFactory.createDistinctToken(),
				TokenFactory.createIdentifierToken("foo"), TokenFactory.createDotToken(),
				TokenFactory.createIdentifierToken("bar"), TokenFactory.createAsToken(),
				TokenFactory.createIdentifierToken("something"), TokenFactory.createCommaToken(),
				TokenFactory.createIdentifierToken("test"), TokenFactory.createDotToken(),
				TokenFactory.createStarToken(), TokenFactory.createCommaToken(),
				TokenFactory.createIdentifierToken("anything"), TokenFactory.createAsToken(),
				TokenFactory.createIdentifierToken("one_more_thing"), TokenFactory.createFromToken(),
				TokenFactory.createIdentifierToken("IIIII"), TokenFactory.createAsToken(),
				TokenFactory.createIdentifierToken("a1"), TokenFactory.createCommaToken(),
				TokenFactory.createIdentifierToken("kljm"), TokenFactory.createIdentifierToken("a2"),
				TokenFactory.createWhereToken(), TokenFactory.createOpenParenToken(),
				TokenFactory.createIdentifierToken("a1"), TokenFactory.createDotToken(),
				TokenFactory.createIdentifierToken("test"), TokenFactory.createComparisonOpToken("="),
				TokenFactory.createStringLitToken("aa"), TokenFactory.createAndToken(),
				TokenFactory.createIdentifierToken("a1"), TokenFactory.createDotToken(),
				TokenFactory.createIdentifierToken("foo"), TokenFactory.createComparisonOpToken("="),
				TokenFactory.createNumericLitToken("1"), TokenFactory.createCloseParenToken(),
				TokenFactory.createOrToken(), TokenFactory.createIdentifierToken("a1"), TokenFactory.createDotToken(),
				TokenFactory.createIdentifierToken("foo"), TokenFactory.createComparisonOpToken(">"),
				TokenFactory.createNumericLitToken("10"), TokenFactory.createSemicolonToken());

		List<Token> actual = lexer.getTokens();
		assertNotNull(actual);
		assertArrayEquals(expected.toArray(), actual.toArray());
	}

	@Test
	void testTokenizeWithBlankQuery() throws InvalidTokenException {
		Lexer lexer = new Lexer("");

		lexer.tokenize();

		List<Token> expected = new ArrayList<>();
		List<Token> actual = lexer.getTokens();
		assertEquals(expected, actual);
	}

	@Test
	void testTokenizeWithInvalidQuery() {
		Lexer lexer = new Lexer("^");

		Exception exception = assertThrows(InvalidTokenException.class, () -> lexer.tokenize());

		String expected = "Unknown token starting with: ^";
		String actual = exception.getMessage();
		assertEquals(expected, actual);
	}

}
