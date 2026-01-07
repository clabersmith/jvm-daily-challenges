fun getFirstNonRepeatingChar(s: String): String {
    //one-liner using extensions/inline functions to get count by char and find first that has 1
    return s.groupingBy { it }
        .eachCount()
        .let { counts -> s.firstOrNull { counts[it] == 1 }?.toString() ?: "" }
}
