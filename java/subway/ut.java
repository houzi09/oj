package testcase;

import TT.FindMinimalPath;
import TT.ResultBean;
import junit.framework.TestCase;


public class CExampleTest extends TestCase
{
	
	/* 测试类*/
	private FindMinimalPath pathClass = new FindMinimalPath();
	
	/*
     * @see TestCase#setUp()
     */
    protected void setUp()
        throws Exception
    {
        super.setUp();
        // 线路清空
    	pathClass.Clear();
    }
    
    /*
     * @see TestCase#tearDown()
     */
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }

		  
	/* 地铁测试基本用例：只测试只有一条线的情况，最短路线长度、最短路线和最优路线分开设计用例*/
	public void testCase1()
	{
		int[] line1 = {1,2,3,4,5};
		int ret;
		pathClass.addLine(1,5,line1);
		ret = pathClass.calcMinPathLen(2,4);
		assertEquals(2,ret);
	}
	
	/* 地铁测试基本用例：最短路线有一条以上的情况，最短路线长度、最短路线和最优路线分开设计用例*/
	public void testCase7()
	{
		int[] line1 = {1,2,3,4,5};
		int[] line2 = {3,6,7,8,9};
		int[] line3 = {2,11,12,9,13,14,15};
		ResultBean compRslt = new ResultBean();
		compRslt.setRet(0);
		compRslt.setpPathLen(7);
		compRslt.setpPathNum(1);
		int[][] paths = {{1,2,3,6,7,8,9,13}};
		compRslt.setPpPathes(paths);
	    ResultBean ret;
		pathClass.addLine(1,5,line1);
		pathClass.addLine(2,5,line2);
		pathClass.addLine(3,7,line3);
		ret = pathClass.searchMinPathes(1,13);
		assertEquals(compRslt,ret);
	}
	
	/* 地铁测试基本用例：最优路线有一条以上的情况，最短路线长度、最短路线和最优路线分开设计用例*/
	public void testCase13()
	{
		int[] line1 = {1,2,3,4,5};
		int[] line2 = {3,6,7,8,9};
		int[] line3 = {4,10,11,8,13,14,15};
		ResultBean compRslt = new ResultBean();
		compRslt.setRet(0);
		compRslt.setpPathLen(6);
		compRslt.setpPathNum(1);
		int[][] paths = {{1,2,3,6,7,8,9}};
		compRslt.setPpPathes(paths);
	    ResultBean ret;
		pathClass.addLine(1,6,line1);
		pathClass.addLine(2,5,line2);
		pathClass.addLine(3,7,line3);
		ret = pathClass.searchBestPathes(1,9);
		assertEquals(compRslt,ret);
	}
}
