fun removeDuplicates(s: String): String =
    s.toSet().joinToString("")  //kotlin preserves order with toSet()
