#!/usr/bin/env groovy

/**
 * Script to generate:
 *  - Spock test file with empty class
 *  - Java file with empty class
 *  - Groovy file with empty class
 *  - Kotlin file with a dummy function
 *
 * Usage:
 *   groovy CreateStubClasses.groovy MyClassName
 */

if (args.length < 1) {
    println "Usage: groovy CreateStubClasses <BaseName>"
    System.exit(1)
}

def baseName = args[0]
def basePath = "../app/src"

generateFiles(basePath, baseName)


/**
 * Generate test and source files for a new component.
 * Prints the generated filenames to stdout.
 *
 * @param basePath relative path to directory
 * @param baseName base class name used to build filenames
 */
def generateFiles(String basePath, String baseName) {

    def spockFile = new File("${basePath}/test/groovy/${baseName}Spec.groovy")
    def javaFile = new File("${basePath}/main/java/${baseName}.java")
    def groovyFile = new File("${basePath}/main/groovy/${baseName}.groovy")
    def kotlinFile = new File("${basePath}/main/kotlin/${baseName}.kt")

    // -- Spock test spec template ---
    spockFile.text = """
    import spock.lang.Specification
    
    class ${baseName}Spec extends Specification {
    }
    """.stripIndent().trim() + "\n"

    // --- Java class template ---
    javaFile.text = """
    public class ${baseName} {
    }
    """.stripIndent().trim() + "\n"

    // --- Groovy class template ---
    groovyFile.text = """
    class ${baseName}Groovy {
    }
    """.stripIndent().trim() + "\n"

    // --- Kotlin file with dummy function ---
    kotlinFile.text = """
    fun implementSolution() {
        println("Replace with method to implement solution")
    }
    """.stripIndent().trim() + "\n"

    println "Generated files:"
    println " - ${spockFile.name}"
    println " - ${javaFile.name}"
    println " - ${groovyFile.name}"
    println " - ${kotlinFile.name}"
}