fun capitalizeFirst(input: String): String {
    return input
        .trim()
        .split(Regex("\\s+"))
        .joinToString(" ") {
            if(it.isEmpty()) "" else
                it[0].uppercase() + it.substring(1)
        }
}