package TT;

import java.util.*;

public class FindMinimalPath
{
	/*******************************************************************************************************************
	函数说明： 增加某条地铁线路
	函数原型： void addLine(int lineNo, int stationNum ,int[] pStationArray)；
	输入参数：
	           lineNo        地铁线路号；
	           stationNum    该条地铁线中的站点数目，由调用者保证不小于2；
	           pStationArray 该条地铁线的所有站点信息，pStationArray指向的存储空间在函数外会被释放，请自行申请存储空间；
	输出参数： 无
	返回值  ： 无
	********************************************************************************************************************/
	List<int[]> staMatrx = new ArrayList<int[]>();
    List<Stack<Integer>> paths = new ArrayList<Stack<Integer>>();
    Stack<Integer> path = new Stack<Integer>();

    public void addLine(int lineNo, int stationNum ,int[] pStationArray)
	{
	    /* 在这里实现功能 */
        staMatrx.add(lineNo, pStationArray);
	    return;

	}

	/*********************************************************************************************************************
	函数说明：计算从起点站到终点站的最短路线长度
	函数原型：int calcMinPathLen(int srcStation, int desStation)；
	输入参数：
	          srcStation  起点站；
	          desStation 终点站；
	输出参数：无
	返回值  ：
	          起点站到终点站的最短路线长度
	          -1：任何出错情况（包括路线不存在、站点不存在、起点和终点重叠等等）
	**********************************************************************************************************************/
	public int calcMinPathLen(int srcStation, int desStation)
	{
        /* 在这里实现功能 */

        path.add(srcStation);
        List<Integer> list = new ArrayList<Integer>();
        int len = -1;


	    return len;

	}




	/**********************************************************************************************************
	函数说明：输出从起点站到终点站的最短路线
	函数原型：public ResultBean searchMinPathes(int srcStation, int desStation);
	输入参数：
	          SrcStation 起点站；
	          DesStation 终点站；
	          Output Param
	          result 返回的结果对象
	返回值  ：
	          0 ：成功
	          -1：任何出错情况（包括路线不存在、站点不存在、起点和终点重叠等等）

	************************************************************************************************************/
	public ResultBean searchMinPathes(int srcStation, int desStation)
	{



		return new ResultBean();
	}


	/*************************************************************************************************
	函数说明：输出从起点站到终点站的最优路线
	函数原型：public ResultBean searchBestPathes(int srcStation, int desStation);
	输入参数：
	         srcStation 起点站；
	         desStation 终点站；
	         Output Param
	         result 返回的结果对象
	返回值 ：
	         0：成功
	         -1：任何出错情况（包括路线不存在、站点不存在、起点和终点重叠等等）
	**************************************************************************************************/
	public ResultBean searchBestPathes(int srcStation, int desStation)
	{
		return new ResultBean();
	}

	/*************************************************************************************************
	函数说明：清空所有的线路信息
	函数原型：void Clear();
	输入参数：无
	输出参数：无
	返回值  ：无
	**************************************************************************************************/
	public void Clear()
	{

	    /* 在这里实现功能 */

	    return ;

	};


}
