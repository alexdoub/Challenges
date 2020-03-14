package alex.com.challenges

import alex.com.challenges.cs.MyJSONParser
import org.junit.Test

/**
 * Created by Alex Doub on 3/5/2020.
 */

class MyJSONParserTest {
//    @Test
    fun test1() {
        MyJSONParser.parseJson(
            """
    
        "title": "my title",
        "glossary": {
            "title": "example glossary",
    		"GlossDiv": {
                "title": "S",
    			"GlossList": {
                    "GlossEntry": {
                        "ID": "SGML",
    					"SortAs": "SGML",
    					"GlossTerm": "Standard Generalized Markup Language",
    					"Acronym": "SGML",
    					"Abbrev": "ISO 8879:1986",
    					"GlossDef": {
                            "para": "A meta-markup language, used to create markup languages such as DocBook.",
    						"GlossSeeAlso": ["GML", "XML"]
                        },
    					"GlossSee": "markup"
                    }
                }
            }
        }
    
""".trimIndent()
        )
    }
}