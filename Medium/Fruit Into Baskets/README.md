<h2><a href="https://practice.geeksforgeeks.org/problems/fruit-into-baskets-1663137462/1">Fruit Into Baskets</a></h2><h3>Difficulty Level : Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">You are visiting a farm that has a single row of fruit trees arranged from left to right.The trees are represented by an integer array <strong>fruits </strong>of size <strong>N</strong>, where <strong>fruits[i] </strong>&nbsp;is the type of fruit the <strong>ith</strong> tree produces.<br>
You want to collect as much fruit as possible.However,the owner has some strict rules that you must follow :</span></p>

<ul>
	<li><span style="font-size:18px">You only have <strong>two baskets&nbsp;</strong>, and each basket can only hold a <strong>single type</strong> of fruit. There is no limit on the amount of fruit each basket can hold.</span></li>
	<li><span style="font-size:18px">Starting from any tree of your choice,you must pick <strong>exactly one fruit</strong> from <strong>every&nbsp;</strong>tree (including the start tree) while moving to the right. The picked fruits must fit in one of the baskets.</span></li>
	<li><span style="font-size:18px">Once you reach a tree with fruit that cannot fit in your baskets, you must stop.</span></li>
</ul>

<p><span style="font-size:18px">Given the integer array fruits , return the <strong>maximum</strong> number of fruits you can pick.</span></p>

<p><br>
<span style="font-size:18px"><strong>Example 1:</strong></span></p>

<div style="background: rgb(238, 238, 238); border: 1px solid rgb(204, 204, 204); padding: 5px 10px; --darkreader-inline-bgimage: initial; --darkreader-inline-bgcolor:#1e1f21; --darkreader-inline-border-top:#3b4143; --darkreader-inline-border-right:#3b4143; --darkreader-inline-border-bottom:#3b4143; --darkreader-inline-border-left:#3b4143;" data-darkreader-inline-bgimage="" data-darkreader-inline-bgcolor="" data-darkreader-inline-border-top="" data-darkreader-inline-border-right="" data-darkreader-inline-border-bottom="" data-darkreader-inline-border-left=""><span style="font-size:18px"><strong>Input:</strong><br>
N = 3<br>
fruits [ ] = { 2, 1, 2 }<br>
<strong>Output:</strong> 3<br>
<strong>Explanation</strong>: We can pick from all three trees. </span></div>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<div style="background: rgb(238, 238, 238); border: 1px solid rgb(204, 204, 204); padding: 5px 10px; --darkreader-inline-bgimage: initial; --darkreader-inline-bgcolor:#1e1f21; --darkreader-inline-border-top:#3b4143; --darkreader-inline-border-right:#3b4143; --darkreader-inline-border-bottom:#3b4143; --darkreader-inline-border-left:#3b4143;" data-darkreader-inline-bgimage="" data-darkreader-inline-bgcolor="" data-darkreader-inline-border-top="" data-darkreader-inline-border-right="" data-darkreader-inline-border-bottom="" data-darkreader-inline-border-left=""><span style="font-size:18px"><strong>Input</strong>:<br>
N = 6<br>
fruits [ ] = { 0, 1, 2, 2, 2, 2 }<br>
<strong>Output: </strong>5<br>
<strong>Explanation</strong>: It's optimal to pick from trees(0-indexed) [1,2,3,4,5].</span></div>

<p><br>
<span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read input or print anything. Your task is to complete function <strong>totalFruits()</strong> which takes the integer array <strong>fruits</strong>&nbsp;and it's size <strong>N</strong> as input parameters and returns the maximum number of fruits the you can pick.</span><br>
<span style="font-size:18px"><strong>Expected Time Complexity:&nbsp;</strong>O(N).<br>
<strong>Expected Auxiliary Space:&nbsp;</strong>O(1).</span></p>

<p><br>
<span style="font-size:18px"><strong>Constraints:</strong></span><br>
<span style="font-size:18px">1 ≤ N ≤ 10<sup>5</sup><br>
0 ≤ fruits<sub>i</sub>&nbsp;&lt;&nbsp;N</span></p>
</div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>two-pointer-algorithm</code>&nbsp;<code>Arrays</code>&nbsp;<code>Data Structures</code>&nbsp;<code>Algorithms</code>&nbsp;