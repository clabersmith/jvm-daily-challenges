import shared.SimpleQueue

class Day26Groovy {
    static SimpleQueue getSimpleQueue() {
        //use two older, non-prod use legacy stacks to match challenge
        def inStack = new Stack()
        def outStack = new Stack()

        def refreshOutIfNeeded = {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop())
                }
            }
        }

        //Groovy's map-to-interface coersion
        [
            enqueue: { e -> inStack.push(e) },
            dequeue: {
                refreshOutIfNeeded()
                if (outStack.isEmpty()) throw new NoSuchElementException()
                outStack.pop()
            },
            peek   : {
                refreshOutIfNeeded()
                if (outStack.isEmpty()) throw new NoSuchElementException()
                outStack.peek()
            },
            isEmpty: { inStack.isEmpty() && outStack.isEmpty() }
        ] as SimpleQueue
    }
}