package edu.msudenver.cs3250.group6.msubanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import edu.msudenver.cs3250.group6.msubanner.entities.User;
import org.junit.Test;

public class UserTest {

    @Test
    public void testInvalidNamedUser() {
        User nullNamed = new User(null, null);
        assertEquals("First_Name", nullNamed.getFirstName());
        assertEquals("Last_Name", nullNamed.getLastName());
        User emptyNamed = new User("", "");
        assertEquals("First_Name", emptyNamed.getFirstName());
        assertEquals("Last_Name", emptyNamed.getLastName());
    }

    @Test
    public void getId() {
        User user = new User();
        // assertNotEquals(0, user.getId());
    }

    @Test
    public void setFirstName() {
        User user = new User();
        user.setFirstName("test name");
        assertEquals("test name", user.getFirstName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setFirstNameNull() {
        User user = new User();
        user.setFirstName(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setFirstNameEmpty() {
        User user = new User();
        user.setFirstName("");
    }

    @Test
    public void setLastName() {
        User user = new User();
        user.setLastName("test name");
        assertEquals("test name", user.getLastName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setLastNameNull() {
        User user = new User();
        user.setLastName(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setLastNameEmpty() {
        User user = new User();
        user.setLastName("");
    }

    @Test
    public void setId() {
        User user = new User();
        user.setId("99999");
        assertEquals("99999", user.getId());
    }

    @Test
    public void getFirstName() {
        User user = new User("test name", "");
        assertEquals("test name", user.getFirstName());
    }

    @Test
    public void getLastName() {
        User user = new User("", "test name");
        assertEquals("test name", user.getLastName());
    }

    @Test
    public void testUser() {
        User user = new User();
        assertEquals("Last_Name", user.getLastName());
        assertEquals("First_Name", user.getFirstName());
    }

    // not really testing anything, but makes for good coverage :/
   /* @Test
    public void testHashCode() {
        User user = new User();
        assertEquals(664411433, user.hashCode());
    }*/

    @Test
    public void testToString() {
        User user = new User();
        assertEquals("User: First_Name Last_Name " + user.getId(), user.toString());
    }

    @Test
    public void testEquals() {
        User user1 = new User("User", "One");
        // must set id if not connected to db
        // otherwise all ids are set to 0
        user1.setId("1");

        // test null and object not an instanceof
        String notUser = "Not a user at all";
        assertFalse(user1.equals(notUser));
        assertFalse(user1.equals(null));

        // test same exact object
        assertTrue(user1.equals(user1));

        // test only different id
        User user2 = new User("User", "One");
        user2.setId("2");
        assertFalse(user1.equals(user2));

        // test only different first name
        User user3 = new User("Different", "One");
        user3.setId("1");
        assertFalse(user1.equals(user3));

        // test only different last name
        User user4 = new User("User", "Different");
        user4.setId(user1.getId());
        assertFalse(user1.equals(user4));

        // test all values the same
        User userCopy = new User();
        userCopy.setFirstName(user1.getFirstName());
        userCopy.setLastName(user1.getLastName());
        userCopy.setId(user1.getId());
        assertTrue(user1.equals(userCopy));
    }
}
