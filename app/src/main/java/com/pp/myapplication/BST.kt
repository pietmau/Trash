package com.pp.myapplication

class BST<T : Comparable<T>> {
    private var bstRoot: Node<T>? = null

    fun add(node: T) {
        add(node, bstRoot)
    }

    private fun add(t: T, root: Node<T>?) {
        when {
            root == null -> bstRoot = Node(t)
            root.data == t -> Unit
            root.data > t && root.left != null -> add(t, root.left)
            root.data > t -> root.left = Node(t)
            root.data < t && root.right != null -> add(t, root.right)
            root.data < t -> root.right = Node(t)
        }
    }

    fun contains(t: T): Boolean =
        bstRoot?.let {
            contains(it, t)
        } ?: false

    private fun contains(root: Node<T>, t: T): Boolean =
        when {
            root.data == t -> true
            root.data > t && root.left != null -> contains(root.left!!, t)
            root.data > t -> false
            root.data < t && root.right != null -> contains(root.right!!, t)
            root.data < t -> false
            else -> false
        }

    fun remove(t: T) {
        if (bstRoot == null || bstRoot!!.data == t) {
            return
        }
        if (bstRoot!!.data > t && bstRoot!!.left != null) {
            scan(t, bstRoot!!.left!!, bstRoot!!)
        }
        if (bstRoot!!.data < t && bstRoot!!.right != null) {
            scan(t, bstRoot!!.right!!, bstRoot!!)
        }
    }

    private fun scan(value: T, currentNode: Node<T>, parentNode: Node<T>) {
        if (currentNode.data == value) {
            remove(currentNode, parentNode)
        }
        if (currentNode.data > value && currentNode.left != null) {
            scan(value, currentNode.left!!, currentNode)
        }
        if (currentNode.data < value && currentNode.right != null) {
            scan(value, currentNode.right!!, currentNode)
        }
    }

    private fun remove(node: Node<T>, parentNode: Node<T>) {
        if (node.left == null && node.right == null) {
            removeSingle(parentNode, node)
            return
        }
        if ((node.left == null && node.right != null) || (node.right == null && node.left != null)) {
            removeWithOneChild(parentNode, node)
            return
        }
        removeWithTwoChildern(parentNode, node)
    }

    private fun removeWithTwoChildern(parentNode: Node<T>, currentNode: Node<T>) {
        val node = getReplacementNode(currentNode.right!!)
        currentNode.data = node.data
        node.left = currentNode.right
        currentNode.right = node.right
    }

    private fun getReplacementNode(currentNode: Node<T>): Node<T> {
        if (currentNode.left == null) {
            val result = currentNode
            currentNode.left = result.right
            return result
        }
        return getReplacementNode(currentNode.left!!)
    }

    private fun removeWithOneChild(parentNode: Node<T>, node: Node<T>) {
        val child = if (node.left == null) {
            node.right
        } else {
            node.left
        }
        if (parentNode.left != null && parentNode.left!!.data == node.data) {
            parentNode.left = child
        }
        if (parentNode.right != null && parentNode.right!!.data == node.data) {
            parentNode.right = child
        }
    }

    private fun removeSingle(
        parentNode: Node<T>,
        node: Node<T>
    ) {
        if (parentNode.right == node) {
            parentNode.right = null
        }
        if (parentNode.left == node) {
            parentNode.left = null
        }
    }
}

data class Node<T : Comparable<T>>(
    var data: T,
    var left: Node<T>? = null,
    var right: Node<T>? = null
)
