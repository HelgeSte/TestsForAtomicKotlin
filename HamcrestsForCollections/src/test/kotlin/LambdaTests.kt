import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
// Source for hamcrest tests: https://www.baeldung.com/hamcrest-collections-arrays

class ListHamcrestTestsKtTest {
    private var list: MutableList<String> = mutableListOf("ab", "cd", "ef", "gh")

    @Test
    fun testHasItem(){
        assertThat(list, hasItem("ab"))
        assertThat(list, not(hasItem("ij")))
    }

    @Test
    fun testHasItems() {
        assertThat(list, hasItems("ab", "ef"))
        assertThat(list, not(hasItems("ab", "ij")))
    }

    @Test
    fun testUsingMap(){
        // using map:
        val result = list.map { it.uppercase() }
        assertThat(result, hasItems("AB", "CD", "EF", "GH"))
    }


    /* ------Check all elements in a collection ----------*/
    @Test
    fun testAllIElementsInList(){
        val collection = listOf("ab", "cd", "ef")
        assertThat(collection, contains("ab", "cd", "ef"))
        // out of order
        assertThat(collection, containsInAnyOrder("ab", "ef", "cd"))
        // too many elements
        assertThat(collection, not(contains("ab", "cd", "ef", "gh")))
    }

    @Test
    fun testIfArrayAndListIsEmpty(){
        val strings: MutableList<String> = mutableListOf()
        assertThat(strings, empty())

        val array: Array<String> = arrayOf()
        assertThat(array, emptyArray())
    }
    /* ------ check sizes -----------------*/
    @Test
    fun checkListSize(){
        val collection = listOf(1, 2, 3, 4, 5)
        assertThat(collection, hasSize(5))
        // ToDo: figure out how to use iterable in kotlin
        //assertThat(collection, Matchers.<String> iterableWithSize(4))

    }

    /* ----------------- JoinToString ----------------*/
    @Test
    fun testJoinWithSeparator(){
        val collection = listOf("a", "b", "c", "d")
        val list1: String = collection.joinToString(" ") { "[$it]" }
        assertEquals(list1,"[a] [b] [c] [d]")

        val joinedList = list.joinToString(" ",
            transform = { "[$it]" })
        assertEquals("[ab] [cd] [ef] [gh]", joinedList)
    }
    /* ----------------- mapIndexed ---------------*/
    @Test
    fun testMapIndexed(){
        val chars = listOf('a','b','c','d')
        assertThat(
            chars.mapIndexed{index, element -> "${index}: $element"},
            contains("0: a", "1: b", "2: c", "3: d"))
    }
    /* ---------------- ignore argument ---------- */
    @Test
    fun useOnlyIndex_IgnoreValueArgument(){
        assertThat(list.mapIndexed { index, _ -> "$index"  } // _ => ignore compiler warning about unused identifiers
       , contains("0","1","2","3"))

        // or use list.indices instead
        assertThat(list.indices.map { "$it" }
            ,contains("0","1","2","3"))
    }

    @Test
    fun testEquals() {
        assertEquals(50, 50)
    }
}