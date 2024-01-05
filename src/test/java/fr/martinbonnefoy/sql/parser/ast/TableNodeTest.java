package fr.martinbonnefoy.sql.parser.ast;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class TableNodeTest {

	@Test
	void testTableName() {
		TableNode tableNode = new TableNode();
		String tableName = "testTable";
		tableNode.setTableName(tableName);

		assertNotNull(tableNode.getTableName());
		assertEquals(tableName, tableNode.getTableName());
	}

	@Test
	void testTableAlias() {
		TableNode tableNode = new TableNode();
		String tableAlias = "alias";
		tableNode.setTableAlias(tableAlias);

		assertNotNull(tableNode.getTableAlias());
		assertEquals(tableAlias, tableNode.getTableAlias());
	}

	@Test
	void testHashCodeEquals() {
		TableNode tableNode1 = new TableNode();
		tableNode1.setTableName("testTable");
		tableNode1.setTableAlias("alias");
		TableNode tableNode2 = new TableNode();
		tableNode2.setTableName("testTable");
		tableNode2.setTableAlias("alias");

		assertEquals(tableNode1.hashCode(), tableNode2.hashCode());
	}

	@Test
	void testEqualsWithEqualsObjects() {
		TableNode tableNode1 = new TableNode();
		tableNode1.setTableName("testTable");
		tableNode1.setTableAlias("alias");

		TableNode tableNode2 = new TableNode();
		tableNode2.setTableName("testTable");
		tableNode2.setTableAlias("alias");

		assertEquals(tableNode1, tableNode2);
	}

	@Test
	void testEqualsWithSameObject() {
		TableNode tableNode = new TableNode();

		assertEquals(tableNode, tableNode);
	}

	@Test
	void testEqualsWithNull() {
		TableNode tableNode = new TableNode();

		assertNotEquals(tableNode, null);
	}

	@Test
	void testEqualsWithDifferentClass() {
		TableNode tableNode = new TableNode();

		assertNotEquals(tableNode, new Object());
	}

	@Test
	void testEqualsWithDifferentTableName() {
		TableNode tableNode1 = new TableNode();
		tableNode1.setTableName("testTable1");
		tableNode1.setTableAlias("alias");

		TableNode tableNode2 = new TableNode();
		tableNode2.setTableName("testTable2");
		tableNode2.setTableAlias("alias");

		assertNotEquals(tableNode1, tableNode2);
	}

	@Test
	void testEqualsWithDifferentTableAlias() {
		TableNode tableNode1 = new TableNode();
		tableNode1.setTableName("testTable");
		tableNode1.setTableAlias("alias1");

		TableNode tableNode2 = new TableNode();
		tableNode2.setTableName("testTable");
		tableNode2.setTableAlias("alias2");

		assertNotEquals(tableNode1, tableNode2);
	}

	@Test
	void testToStringWithAlias() {
		TableNode tableNode = new TableNode();
		tableNode.setTableName("testTable");
		tableNode.setTableAlias("alias");

		assertEquals("testTable AS alias", tableNode.toString());
	}

	@Test
	void testToStringWithoutAlias() {
		TableNode tableNode = new TableNode();
		tableNode.setTableName("testTable");

		assertEquals("testTable", tableNode.toString());
	}

}
