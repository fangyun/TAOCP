# Notes for TAOCP

##1 算法的形式化描述

我们定义一个**计算方法**为一个四元组（**Q**, **I**, **Ω**, f）,每个字母的意义为:
**Q**: 表示计算状态的集合
**I**: 表示输入的集合
**Ω**: 表示输出的集合
f: 表示计算规则的集合
满足如下约束：

![](https://www.ituring.com.cn/download/01Qie91kvzGW)
对集合**I**中的每一个输入x定义一个序列：![enter image description here](https://www.ituring.com.cn/download/01Qie9s7Cjef)，满足如下规则：
![](https://www.ituring.com.cn/download/01Qie9tiPe45)
如果k是使![](https://www.ituring.com.cn/download/01Qie9waVPrX)在**Ω**中为最小的整数，那么就说这个计算序列在k步 中终止，而且在此种情况下说x产生了输出![](https://www.ituring.com.cn/download/01Qie9waVPrX)。可能有些序列永远不会终止，这只能称为一个**计算方法**，而不能称之为**算法**。 **算法**是一种对**I**中所有的x在有限步中终止的**计算方法**。

## 2 欧几里得算法的形式化描述

**Q**定义为所有单点(n)，所有有序偶(m, n)和所有有序四元组（m, n , r, 1) , (m, n , r, 2)和（m, n ,q,3)的集合。 其中m、n、q为正整数， q为非负整数。

**I** 为所有有序偶(m, n)

**Ω** 为所有单点(n)

函数$f$ 定义如下：
$f((m,n)) = (m,n,0,1)$ 
$f((m,n,r,1)) = (m,n, m\%n, 2)$ 
$f((m,n,r,2)) = (n), if \space r=0; (m,n,r,3) \space otherwise $
$f((m,n,p,3) = f((n, p,p,1))$
$f((n)) = (n)$ 

以输入为（8, 12）为例， 其计算序列为(8,12), (8,12,0,1),  (8, 12, 8, 2),  (8, 12, 8, 3) ,  (12, 8, 8, 1),  (12, 8, 4, 2), (12, 8, 4, 3),  (8,4, 4, 1), (8, 4, 0, 2), (4)

### 2.1 参考

1. http://www.voidcn.com/article/p-amrutrch-bm.html
2. https://www.ituring.com.cn/article/details/832