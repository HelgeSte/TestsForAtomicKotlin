import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.hamcrest.MatcherAssert.*
import org.hamcrest.CoreMatchers.*
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach

class ListHamcrestTestsKtTest {
    var list: MutableList<String> = mutableListOf<String>("ab", "cd", "ef")

    @Before
    fun add_gh(){
        list.add("gh")
    }
    @Test
    fun testListHas_cd(): Unit { list.add("cd")
        assertThat(list, hasItem("cd"))
    }
    @Test
    fun testListHas_gh(): Unit { list.add("gh")
        assertThat(list, hasItem("gh"))
    }


    @Test
    fun testsListHasItems() {
        assertThat(list, hasItems("ab", "ef"))
    }

    @Test
    fun testListIsUpperCase(){
        var result = list.map(){it.uppercase()}
        assertThat(result, hasItems("AB", "CD", "EF", "GH"))
    }

    @Test
    fun testJoinWithSeparator(){
        var joinedList = list.joinToString(" ",
            transform = { "$it" })
        assertEquals("ab cd ef gh", joinedList)
    }

    @Test
    fun testEquals() {
        assertEquals(50, 50)
    }
}