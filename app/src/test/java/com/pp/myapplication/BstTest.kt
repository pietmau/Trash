package com.pp.myapplication

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test


class BstTest {

    @Test
    fun add_add_works() {
        val bst = createBst()
        assertThat(bst.contains(27)).isTrue()
        assertThat(bst.contains(10)).isTrue()
        assertThat(bst.contains(5)).isTrue()
        assertThat(bst.contains(20)).isTrue()
        assertThat(bst.contains(15)).isTrue()
    }

    @Test
    fun remove_works() {
        val bst = createBst()
        bst.remove(27)
        assertThat(bst.contains(27)).isFalse()
        assertThat(bst.contains(10)).isTrue()
        assertThat(bst.contains(5)).isTrue()
        assertThat(bst.contains(20)).isTrue()
        assertThat(bst.contains(15)).isTrue()

    }

    @Test
    fun remove_oneworks() {
        val bst = createBst()
        bst.remove(15)
        assertThat(bst.contains(15)).isFalse()
        assertThat(bst.contains(27)).isTrue()
        assertThat(bst.contains(10)).isTrue()
        assertThat(bst.contains(5)).isTrue()
        assertThat(bst.contains(20)).isTrue()
    }

    @Test
    fun remove_twoworks() {
        val bst = createBst()
        bst.remove(20)
        assertThat(bst.contains(20)).isFalse()
        assertThat(bst.contains(27)).isTrue()
        assertThat(bst.contains(10)).isTrue()
        assertThat(bst.contains(5)).isTrue()
        assertThat(bst.contains(15)).isTrue()

    }

    @Test
    fun remove_twotwoworks() {
        val bst = createBst()
        bst.remove(5)
        assertThat(bst.contains(27)).isTrue()
        assertThat(bst.contains(10)).isTrue()
        assertThat(bst.contains(5)).isFalse()
        assertThat(bst.contains(20)).isTrue()
        assertThat(bst.contains(15)).isTrue()

    }

    private fun createBst(): BST<Int> {
        val bst = BST<Int>()
        bst.add(10)
        bst.add(5)
        bst.add(20)
        bst.add(1)
        bst.add(7)
        bst.add(15)
        bst.add(27)
        bst.add(19)
        return bst
    }
}