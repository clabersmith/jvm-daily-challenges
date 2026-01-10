import java.util.Objects

fun <E> removeValueFromList(value: E, list: List<E>) : List<E> {
    return list.filterNot { Objects.equals(it, value) }
}
