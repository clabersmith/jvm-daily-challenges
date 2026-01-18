fun getLongestWord(sentence: String?): String =
    sentence?.trim()?.takeIf { it.isNotEmpty() }
        ?.split(Regex("\\s+"))
        ?.maxByOrNull { it.length }
        ?: ""