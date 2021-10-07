#include <stdio.h>

struct node{
	int startIndex1;
	int endIndex1;
	int startIndex2;
	int endIndex2;
};

struct list{
	struct node arr[1000];
	int size;
};

char theta(char ch){
	switch(ch){
		case 'A':
				ch='T';
				break;
		case 'T':
				ch='A';
				break;
		case 'C':
				ch='G';
				break;
		case 'G':
				ch='C';
				break;
	}
	return ch;
}

struct list checkhairpin(char str[],int N,int k){
	struct list ans;
	ans.size=0;
	for(int i=0;i<N-k;i++){
		for(int j=N-1;j>=i+k;j--){
			if(str[i]==theta(str[j])){
				int count=0;
				int m=i,n=j;
				for(;m<n;m++,n--){
					if(str[m]==theta(str[n])){
						count++;
					}
					else{
						break;
					}
				}
				if(count>=k){
					ans.arr[ans.size].startIndex1=i+1;
					ans.arr[ans.size].endIndex1=m-1+1;
					ans.arr[ans.size].startIndex2=j+1;
					ans.arr[ans.size].endIndex2=n+1+1;
					ans.size++;
				}
			}
		
		}
	}
	return ans;
}

int checkinterbond(char Si[],char Sj[],int N){
	int count1=0,count2=0;
	int i=0,j=N-1;
	while(i<N && Si[i]==theta(Sj[j])){
		count1++;
		i++;
		j--;
	}
	i=0;
	j=0;
	while(i<N && Si[i]==theta(Sj[j])){
		count2++;
		i++;
		j++;
	}
	
	if(count1==N){
		return 1;
	}
	else if(count2==N){
		return 2;
	}
	else{
		return 0;
	}
}

int main(){
	int N,k;
	printf("How many DNA strand you want to Enter?\nAns:");
	scanf("%d",&N);
	printf("Enter k:");
	scanf("%d",&k);
	printf("Enter DNA strands.\n");
	char S[N][1000];
	for(int i=0;i<N;i++){
		printf("%d) ",i+1);
		scanf("%s",S[i]);
	}
	
	for(int i=0;i<N;i++){
		
		int arrSize=0;
		while(S[i][arrSize]!='\0'){
			arrSize++;
		}
		
		struct list ans=checkhairpin(S[i],arrSize,k);
	
		if(ans.size>0){
			printf("\n%d) hairpin exist\n",i+1);
			for(int j=0;j<ans.size;j++){
				printf("%d) %d-%d,%d-%d\n",j+1,ans.arr[j].startIndex1,ans.arr[j].endIndex1,ans.arr[j].endIndex2,ans.arr[j].startIndex2);
			}
		}
		else{
			printf("\n%d) hairpin doesn't exist\n",i+1);
		}
	}
	
	printf("\nList of inter DNA strand bonds\n");
	int num=0;
	for(int i=0;i<N-1;i++){
		int sizei=0;
		while(S[i][sizei]!='\0'){
			sizei++;
		}
		for(int j=i+1;j<N;j++){
			int sizej=0;
			while(S[j][sizej]!='\0'){
				sizej++;
			}
			if(sizei==sizej){
				int ansinterbond=checkinterbond(S[i],S[j],sizei);
				if(ansinterbond==1 || ansinterbond==2){
					printf("%d)%d-%d\n",++num,i+1,j+1);
				}
			}
		}
	}
	
	return 0;
}
