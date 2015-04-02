#include <stdio.h>
#include <stdlib.h>
#include <string.h>


void GetNext(char* p,int** pnext)  
{  
    int pLen = strlen(p);
    *pnext = malloc(sizeof(int)*pLen);
    int* next = *pnext;
    next[0] = -1;
    int k = -1;  
    int j = 0;  
    while (j < pLen - 1)  
    {  
        //p[k]表示前缀，p[j]表示后缀  
        if (k == -1 || p[j] == p[k])   
        {  
            ++k;  
            ++j;  
            next[j] = k;  
        }  
        else   
        {  
            k = next[k];  
        }  
    }  
}  



int KmpSearch(char* s, char* p, int* next)
{  
    int i = 0;  
    int j = 0;  
    int sLen = strlen(s);  
    int pLen = strlen(p);  
    while (i < sLen && j < pLen)  
    {  
        //①如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++      
        if (j == -1 || s[i] == p[j])  
        {  
            i++;  
            j++;  
        }  
        else  
        {  
            //②如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]      
            //next[j]即为j所对应的next值        
            j = next[j];  
        }  
    }  
    if (j == pLen)  
        return i - j;  
    else  
        return -1;  
}  

int main()
{
    char str[]="abacababc";
    char pat[]="abab";
    int* next;
    GetNext(str, &next);
    printf("%d\n",KmpSearch(str, pat, next));
    free(next);
}


