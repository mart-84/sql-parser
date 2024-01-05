package fr.martinbonnefoy.sql.parser;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.martinbonnefoy.sql.parser.exceptions.InvalidTokenException;

/**
 * 
 */
public class Lexer {

	/**
	 * The query to analyze.<br>
	 * Must not be null
	 */
	private String query;

	/**
	 * The tokens' list representing the query
	 */
	private List<Token> tokens = new ArrayList<>();

	private Map<Pattern, TokenType> regexTokenMap;

	/**
	 * Creates a {@code Lexer} for the given query.<br>
	 *
	 * @param query The query to tokenize. Must not be null
	 */
	public Lexer(String query) {
		this.setQuery(query);
		// The {@code LinkedHashMap} keeps the inserting order
		this.regexTokenMap = new LinkedHashMap<>();
		this.initializeRegexTokenMap();
	}

	private void initializeRegexTokenMap() {
		this.addRegexAndToken("^SELECT", TokenType.SELECT);
		this.addRegexAndToken("^FROM", TokenType.FROM);
		this.addRegexAndToken("^WHERE", TokenType.WHERE);
		this.addRegexAndToken("^DISTINCT", TokenType.DISTINCT);
		this.addRegexAndToken("^AS", TokenType.AS);
		this.addRegexAndToken("^AND", TokenType.AND);
		this.addRegexAndToken("^OR", TokenType.OR);
		this.addRegexAndToken("^[a-z][a-z0-9_]*", TokenType.IDENTIFIER);
		this.addRegexAndToken("^\\d+", TokenType.NUMERIC_LIT);
		this.addRegexAndToken("^'[a-z0-9.;,?:\\/!*&()\\[\\]\\-|_=+{} ]*'", TokenType.STRING_LIT);
		this.addRegexAndToken("^,", TokenType.COMMA);
		this.addRegexAndToken("^\\.", TokenType.DOT);
		this.addRegexAndToken("^\\*", TokenType.STAR);
		this.addRegexAndToken("^;", TokenType.SEMICOLON);
		this.addRegexAndToken("^\\(", TokenType.OPEN_PAREN);
		this.addRegexAndToken("^\\)", TokenType.CLOSE_PAREN);
		this.addRegexAndToken("^(?:=|<>|<|<=|=>|>)", TokenType.COMPARISON_OP);
		this.addRegexAndToken("^\\s+", null);
	}

	private void addRegexAndToken(String regex, TokenType tokenType) {
		this.regexTokenMap.put(Pattern.compile(regex, Pattern.CASE_INSENSITIVE), tokenType);
	}

	public void tokenize() throws InvalidTokenException {
		while (this.query.length() > 0) {
			Token token = null;
			boolean matched = false;

			for (Map.Entry<Pattern, TokenType> entry : this.regexTokenMap.entrySet()) {
				Matcher matcher = entry.getKey().matcher(this.query);
				matched = matcher.find();

				if (matched) {
					token = this.createTokenFromMatch(matcher, entry.getValue());
					this.query = matcher.replaceFirst("");
					break;
				}
			}

			if (!matched) {
				throw new InvalidTokenException(
						"Unknown token starting with: " + this.query.substring(0, Math.min(this.query.length(), 20)));
			}

			if (token != null) {
				this.tokens.add(token);
			}
		}

	}

	private Token createTokenFromMatch(Matcher matcher, TokenType tokenType) {
		String value = matcher.group();

		if (tokenType != null && tokenType.equals(TokenType.STRING_LIT)) {
			// remove starting and ending quotes
			value = value.substring(1, value.length() - 1);
		}

		// Whitespace don't create tokens
		if (tokenType != null) {
			return TokenFactory.createToken(tokenType, value);
		}
		return null;
	}

	/**
	 * @param query the query to set. Must not be null
	 */
	public void setQuery(String query) {
		if (query == null) {
			throw new IllegalArgumentException("The query must not be null");
		}
		this.query = query;
	}

	/**
	 * @return the query
	 */
	public String getQuery() {
		return this.query;
	}

	/**
	 * @return the tokens
	 */
	public List<Token> getTokens() {
		return this.tokens;
	}

	@Override
	public String toString() {
		return "Lexer [query=" + this.query + ", tokens=" + this.tokens + "]";
	}

}
