package com.wuzh.algorithm.stackqueue;

import java.util.Iterator;
import java.util.List;

/**
 * @author wzh
 * @description 341. 扁平化嵌套列表迭代器
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 * <p>
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 * <p>
 * 示例 1:
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 * <p>
 * 示例 2:
 * 输入: [1,[4,[6]]]
 * 输出: [1,4,6]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
 * @create 2020-03-30 22:44
 */
public class NestedIterator_341 implements Iterator<Integer> {

    public NestedIterator_341(List<NestedInteger> nestedList) {

    }

    @Override
    public Integer next() {

        return null;
    }

    @Override
    public boolean hasNext() {

        return false;
    }
}

interface NestedInteger {

    public boolean isInteger();

    public Integer getInteger();

    public List<NestedInteger> getList();
}

