#!/usr/bin/env groovy

/**
 * Script to update tasks.md:
 *  - Creates link to the day's solution files
 *  - Sets the status of the day to completed
 *
 * Usage:
 *   groovy UpdateTask.groovy MyClassName
 */

if (args.length < 1) {
    println "Usage: UpdateTask <BaseName>"
    System.exit(1)
}

def baseName = args[0]
def basePath = "app/src"

updateTask(basePath, baseName)

/**
 * Updates the tasks.md file with completion status and links to solution files
 * Prints the generated filenames to stdout.
 *
 * @param basePath relative path to directory
 * @param baseName base class name used to build filenames
 */
static def updateTask(String basePath, String baseName) {
    def javaLink   = "[solution](${basePath}/main/java/${baseName}.java)"
    def kotlinLink = "[solution](${basePath}/main/kotlin/${baseName}.kt)"
    def groovyLink = "[solution](${basePath}/main/groovy/${baseName}.groovy)"
    def status     = "\u2705 Completed"

    def m = (baseName =~ /(?i)^day0*(\d+)$/)
    def day = m ? m[0][1].toInteger() : baseName

    // closure to format a cell value: ensure a single space before the content then right-pad to the given width
    def fit = { String value, int width ->
        " ${value}".padRight(width - 1)
    }

    def file = new File("../tasks.md")
    def updatedLines = file.readLines().collect { line ->
        if (line ==~ /^\|\s*${day}\s+\|.*/) {

            // Split but keep empty cells
            def cells = line.split(/\|/, -1).toList()

            // Capture original column widths
            def widths = cells.collect { it.length() }

            // Replace only the content (keep surrounding spaces)
            cells[3] = fit(javaLink,   widths[3])
            cells[4] = fit(kotlinLink, widths[4])
            cells[5] = fit(groovyLink, widths[5])
            cells[6] = fit(status,     widths[6])

            // Re-pad each cell to original width
            cells = cells.withIndex().collect { cell, i ->
                cell.padRight(widths[i])
            }

            // Reassemble row
            return cells.join("|")
        }
        line
    }

    file.setText(updatedLines.join("\n") + "\n", "UTF-8")
}

