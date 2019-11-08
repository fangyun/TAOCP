# Notes for TAOCP

##算法的形式化描述

我们定义一个**计算方法**为一个四元组（**Q**, **I**, **Ω**, f）,每个字母的意义为:
**Q**: 表示计算状态的集合
**I**: 表示输入的集合
**Ω**: 表示输出的集合
f: 表示计算规则的集合
满足如下约束：

![](https://www.ituring.com.cn/download/01Qie91kvzGW)
对集合**I**中的每一个输入x定义一个序列：![](https://www.ituring.com.cn/download/01Qie9s7Cjef)，满足如下规则：
![](https://www.ituring.com.cn/download/01Qie9tiPe45)
如果k是使![](https://www.ituring.com.cn/download/01Qie9waVPrX)在**Ω**中为最小的整数，那么就说这个计算序列在k步 中终止，而且在此种情况下说x产生了输出![](https://www.ituring.com.cn/download/01Qie9waVPrX)。可能有些序列永远不会终止，这只能称为一个**计算方法**，而不能称之为**算法**。 **算法**是一种对**I**中所有的x在有限步中终止的**计算方法**。

## 欧几里得算法的形式化描述

**Q**定义为所有单点(n)，所有有序偶(m, n)和所有有序四元组（m, n , r, 1) , (m, n , r, 2)和（m, n ,q,3)的集合。 其中m、n、q为正整数， q为非负整数。

**I** 为所有有序偶(m, n)

**Ω** 为所有单点(n)

函数$f$ 定义如下：
$$
f((m,n)) = (m,n,0,1) \\
f((m,n,r,1)) = (m,n, m\%n, 2) \\  
f((m,n,r,2)) = (n), if \space r=0; (m,n,r,3) \space otherwise \\
f((m,n,p,3) = f((n, p,p,1)) \\
f((n)) = (n)
$$

以输入为（8, 12）为例， 其计算序列为(8,12), (8,12,0,1),  (8, 12, 8, 2),  (8, 12, 8, 3) ,  (12, 8, 8, 1),  (12, 8, 4, 2), (12, 8, 4, 3),  (8,4, 4, 1), (8, 4, 0, 2), (4)

### 2.1 参考

1. http://www.voidcn.com/article/p-amrutrch-bm.html
2. https://www.ituring.com.cn/article/details/832



## 可行算法的形式化描述

### 3.1 Markov algorithm

https://en.wikipedia.org/wiki/Markov_algorithm

$$\displaystyle \left\{{\begin{matrix}|b&\to &ba|\\ab&\to &ba\\b&\to &\\{*}|&\to &b*&\\{*}&\to &c&\\|c&\to &c\\ac&\to &c|\\c&\to \cdot \end{matrix}}\right.$$

For example, the process of applying the algorithm described above to the word $|*||$ results in the sequence of words $|b*|$, $ba|*|$, $a|*|$, $a|b*$, $aba|*$, $baa|*$, $aa|*$, $aa|c$, $aac$, $ac|$ and $c||$, after which the algorithm stops with the result $.||$

### 3.2 Effectiveness

If we wish to restrict the notion of algorithm so that only elementary operations are involved, we can place restrictions on Q, I, Ω and f, for example as follows: ......

#### 3.2.1 参考

https://www.rudikershaw.com/articles/computationalmethod3

http://mi.mathnet.ru/eng/tm1178

https://www.amazon.com/Theory-Algorithms-Mathematics-its-Applications/dp/9027727732

http://opac.nlc.cn/F?func=item-global&doc_library=NLC09&doc_number=000374290



## Section 1.1 Exercises

* Ex6. 参见P7, 公式=$(12*ln(2)/\pi^2)*ln(n)$. 
  So $T_5=(12*0.693147181/9.869604401)*1.609437912=1.356379413$
* Ex8. 参考：
  * https://www.amazon.com/Foundations-Mathematical-Logic-Dover-Mathematics/dp/0486634620
  * https://readingtaocp.wordpress.com/category/vol1/
  * https://books.google.com/books?id=27dkTJFrLZIC&printsec=frontcover#v=onepage&q&f=false
  * http://opac.nlc.cn/F?func=item-global&doc_library=NLC09&doc_number=001041143
  * https://en.wikipedia.org/wiki/Haskell_Curry
  * https://stackoverflow.com/questions/26742562/knuth-the-art-of-computer-programming-ex-1-1-8?noredirect=1&lq=1
* Ex9. 参考
  * http://tord.net/section.1.1.html , 关键有： $f_1(t_{Q_2}(q_2))=t_{Q_2}(f^k_2(q_2))$ , that is "存在函数$t_{Q_2}$，使得代码的状态的$t$函数的算法$f_1$计算，等于代码状态的k次迭代$f_2$代码计算后的$t$函数"

## Section 1.2.1 Mathematical Induction

* $1+3+5+...+(2n+1)=n^2$
* Fibonacci inequality: $F(n) \leq (\frac{1+\sqrt{5}}{2})^{n-1}$
* Extended Euclid Algorithm and prove
* Inductive assertion
* invarants
* weakest precondition
* "Assigning Meanings to Programs"
* "A Discipline of Programming"

## Section 1.2.1 Exercises

* Ex8. 
$$
\begin{align*}
Let \space [(n-1)^2+n]&=n^2-n+1=a, \\
Let \space \{[(n+1)-1)]^2+(n+1)\}&=n^2+n+1=b \\
if \space n^3 &= a+(a+2)+....+[a+2(n-1)] , then\\
(n+1)^3 &= (n^2+2n+1)(n+1) \\
		&= \frac{(2(n^2+n+1)+2n)(n+1)}{2} \\
		&= \frac{(2b+2n)(n+1)}{2} \\		
		&= b+(b+2)+...+(b+2n) \\
\end{align*}
$$
* Ex8-b.
$$
\begin{align*}
if \space 1^3+2^3+...n^3 	&=(1+2+...+n)^2, then \\
			1^3+2^3+...+(n+1)^3	&=(1+2+...+n)^2+(n+1)^3 \\
								&=(1+2+...+n)^2+(n+1)^3 \\
								&=(\frac{(n+1)n}{2})^2+(n+1)^3 \\
								&=(n+1)^2(\frac{n^2+4n+4}{4}) \\
								&=(n+1)^2(\frac{(n+2)}{2})^2 \\
								&=(\frac{(n+2)(n+1)}{2})^2 \\
								&=(1+2+...+(n+1))^2
\end{align*}
$$
* Ex10. Key steps: 
  $$
  \begin{align*}
  2^{n+1} &= 2*2^n \\
  		&> 2*n^3 \\
  		&> (1+\frac{1}{n})*n^3
  \end{align*}
  $$

* Ex11. Key steps: Try calculate first three items，conjecture formula：
  $$
  \begin{align*}
  For \space S_k 	&= 1/5 \space ,where \space k=1 \\
  				&= -2/17 \space , where \space k=2 \\
  				&= 3/37 \space , where \space k=3 \\
  \end{align*}
  $$

* Ex12. TBD. Ref  http://tord.net/section.1.2.1.html
* Ex13.  TBD. Ref http://tord.net/section.1.2.1.html
* Ext15. TBD. Ref http://tord.net/section.1.2.1.html. **良序化(Well-ordering)**是**广义归纳法(Generalized Induction)**的基础。

## Section 1.2.2 Exercises

* Ex5. binary expansion
* Ex8. decimal expansion
* Ex22. natural logarithms and common logarithms can be used to get approximate values of binary logarithms

## Section 1.2.3 Sums and Products

### 1 Rules for Sums
* Rule a: Distributive law, for products of sums:
  
  * $\displaystyle (\sum_{R(j)}a_j)(\sum_{S(j)}b_j)=\sum_{R(j)}(\sum_{S(j)}a_jb_j)$ ，和的积=积的和
  
* Rule b: Change of variable:
  * $\displaystyle \sum_{R(i)}a_i=\sum_{R(j)}a_j=\sum_{R(p(j))}a_{p(j)}$
  * Important cases: $\displaystyle \sum_{R(j)}a_j=\sum_{R(c+j)}a_{c+j}=\sum_{R(c-j)}a_{c-j}$, 下标的位移
  
* Rule c: Interchanging order of summation:  
  
  * Example 2.  : $\displaystyle \sum_{i=1}^{n}\sum_{j=1}^{i} a_{ij}=\sum_{j=1}^{n}\sum_{i=j}^{n}a_{ij}=\sum_{i=1}^{n}\sum_{j=i}^{n}a_{ij}$  . 内循环的内变量j与外变量关系j$\in$ (1..i) 等价为 j$\in$(i..n).
  
* Rule d: Manipulating the domain : 

  * $\displaystyle \sum_{R(j)}a_j+\sum_{S(j)}a_j=\sum_{R(j) or S(j)}a_j+\sum_{R(j) and S(j)}a_j$

### 2 Examples

* geometric progression
* arithmetic progression