/* C Program to count the Number of Lines in a Text File  */
#include <stdio.h>
#include <string.h>
#include <stdlib.h>


char check(char *cdna)
{//https://en.wikipedia.org/wiki/DNA_codon_table
//Inverse table (compressed using IUPAC notation)
	
	if(strcmp(cdna, "TTG")==0 || strcmp(cdna, "TTA")==0 || 
				strcmp(cdna, "CTG")==0 || strcmp(cdna, "CTA")==0 || 
				strcmp(cdna, "CTT")==0 || strcmp(cdna, "CTC")==0 
				|| strcmp(cdna, "YTR")==0 || strcmp(cdna, "CTN")==0) return 'L';
		
		else if(strcmp(cdna, "TTC")==0 || strcmp(cdna, "TTT")==0 
					|| strcmp(cdna, "TTY")==0) return 'F';
		
		else if(strcmp(cdna, "TGG")==0  ) return 'W';
		
		else if(strcmp(cdna, "TGA")==0 || strcmp(cdna, "TAG")==0 || 
				strcmp(cdna, "TAA")==0 || strcmp(cdna, "TRA")==0
				|| strcmp(cdna, "TAR")==0 ) return '#';  //  STOP STOP
				
		else if(strcmp(cdna, "TGC")==0 || strcmp(cdna, "TGT")==0
		|| strcmp(cdna, "TGY")==0) return 'C';

		else if(strcmp(cdna, "TCG")==0 || strcmp(cdna, "TCA")==0 || 
				strcmp(cdna, "TCC")==0 || strcmp(cdna, "TCT")==0 || 
				strcmp(cdna, "AGC")==0 || strcmp(cdna, "AGT")==0
				|| strcmp(cdna, "TCN")==0|| strcmp(cdna, "AGY")==0) return 'S';
		
		else if(strcmp(cdna, "TAT")==0 || strcmp(cdna, "TAC")==0
		|| strcmp(cdna, "TAY")==0)  return 'Y';
		
		else if(strcmp(cdna, "AGG")==0 || strcmp(cdna, "AGA")==0 || 
				strcmp(cdna, "CGA")==0 || strcmp(cdna, "CGG")==0 || 
				strcmp(cdna, "CGT")==0 || strcmp(cdna, "CGC")==0
				|| strcmp(cdna, "CGN")==0 || strcmp(cdna, "MGR")==0) return 'R';
		
		else if(strcmp(cdna, "CCG")==0 || strcmp(cdna, "CCT")==0 || 
			strcmp(cdna, "CCC")==0 || strcmp(cdna, "CCA")==0
			|| strcmp(cdna, "CCN")==0) return 'P';
		
		else if(strcmp(cdna, "GGA")==0 || strcmp(cdna, "GGG")==0 || 
			strcmp(cdna, "GGT")==0 || strcmp(cdna, "GGC")==0
			|| strcmp(cdna, "GGN")==0) return 'G';
	
		else if(strcmp(cdna, "GCG")==0 || strcmp(cdna, "GCA")==0 || 
			strcmp(cdna, "GCC")==0 || strcmp(cdna, "GCT")==0
			|| strcmp(cdna, "GCN")==0) return 'A';
	
		else if(strcmp(cdna, "ACA")==0 || strcmp(cdna, "ACG")==0 || 
			strcmp(cdna, "ACT")==0 || strcmp(cdna, "ACC")==0 
			|| strcmp(cdna, "ACN")==0) return 'T';
	
		else if(strcmp(cdna, "GTA")==0 || strcmp(cdna, "GTC")==0 || 
			strcmp(cdna, "GTG")==0 || strcmp(cdna, "GTT")==0
			|| strcmp(cdna, "GTN")==0) return 'V';
	
		else if(strcmp(cdna, "ATA")==0 || strcmp(cdna, "ATT")==0 || 
			strcmp(cdna, "ATC")==0|| strcmp(cdna, "ATH")==0) return 'I';
	
		else if(strcmp(cdna, "GAA")==0 || strcmp(cdna, "GAG")==0
		|| strcmp(cdna, "GAR")==0)  return 'E';
			
		else if(strcmp(cdna, "GAT")==0 || strcmp(cdna, "GAC")==0
		|| strcmp(cdna, "GAY")==0)  return 'D';
		
		else if(strcmp(cdna, "CAA")==0 || strcmp(cdna, "CAG")==0
		|| strcmp(cdna, "CAR")==0)  return 'Q';
	
		else if(strcmp(cdna, "CAT")==0 || strcmp(cdna, "CAC")==0
		|| strcmp(cdna, "CAY")==0)  return 'H';
	
		else if(strcmp(cdna, "AAA")==0 || strcmp(cdna, "AAG")==0
		|| strcmp(cdna, "AAR")==0)  return 'K';
	
		else if(strcmp(cdna, "AAT")==0 || strcmp(cdna, "AAC")==0
		|| strcmp(cdna, "AAY")==0)  return 'N';
	
		else if(strcmp(cdna, "ATG")==0 )  return 'M';
		
		else{  printf("mistake |%s|", cdna); return 'X';} //return '\0';
	
}


int main()
{
    FILE *fp;
    int count = 0, i=0 ;  // Line counter (result)
    char filename[99],line[111]="",fixline[111]="",code[4]="", output[99] ;
		char *comp , *cdna , *snpCdna , *snp_prot , *prot ;
    char c, base;  
    int bp,j, maxbases, k ;
		
		printf("  This program translate cDNA into a protein\n\n");
		//Get file name from user. The file should be
    // either in current folder or complete path should be provided
    printf("Enter fastA file name: ");
    scanf("%s", filename);
    // Open the file
    fp = fopen(filename, "r");
		
		// Check if file exists
    if (fp == NULL)
    {
        printf("Could not open file %s", filename);
        return 0;
    }

		// Extract characters from file and store in character c
    for (c = getc(fp); c != EOF; c = getc(fp))
        if (c == '\n') // Increment count if this character is newline
            count++;
    // Close the file
    fclose(fp);
    //printf("The file %s has %d lines\n ", filename, count);
		maxbases	= (count-1)*71 ;
		cdna = (char *) malloc( maxbases*sizeof( char )  );
 		cdna[0]='\0'; //adiasma apo ta skoypidia

			 FILE * nf;
			 printf("Enter file name for output data: ");
  		 scanf("%s", output);
  		 nf = fopen (output, "w");
		

			 // Open the file
    	fp = fopen(filename, "r");
			fgets(line, 202, (FILE*)fp);
			printf("fastA description  %s", line);
			fprintf(nf, "fastA description:  %s", line);
     	     
    // Extract lines from file and store in cdna 
		 while(!feof(fp))
    {		
       	  fgets(line, 77, (FILE*)fp);
        	k=strlen(line);
					//	printf("%d size=%d  %s\n",i,k ,line);  ///print lines 1 by 1	
					memcpy(fixline, line, strlen(line)-1);//get rid of \n
					//appent lines
				if(k==71 || k==61)	strcat(cdna,fixline);
 		}
		 	// Close the file
	    fclose(fp);
 			//add last line
 			if(strlen(line)<71)	strcat(cdna,line);
	          
                                    
			fprintf(nf, "\n cdna \n=%s=\n", cdna);
		
			k=strlen(cdna);
			prot = (char *) malloc( ((k/3)+1)*sizeof( char )  );	
			for(i=0;i<k;i=i+3)
 			{
 				code[0]=cdna[i];
				code[1]=cdna[i+1];
				code[2]=cdna[i+2];
				//printf("  %s ",code);
				prot[i/3]=check(code);
			 }
			 prot[i/3]='\0';
			 
			printf("\n\n prot \n=%s=  \n",prot);
	  	fprintf(nf, "\n\n prot \n=%s=  \n",prot);
 			
 			snpCdna = (char *) malloc( (k+1)*sizeof( char )  );
			snp_prot = (char *) malloc( (k/3)*sizeof( char )  );

			strcpy(snpCdna,cdna);
			base='x';
			do{
			 			
			printf("\n\n\t\t*****************************\n");
			printf(  "\n\t\t  ********* SNPs ********** \n\n");
 			printf("give the number of the base that you want to change	\n\t\t(give '0' to exit):\n");
 			scanf("%d", &bp);
 			if (bp==0) goto TELOS;
 			printf("\n old base is %c\n", snpCdna[bp-1]);
 			printf("give polymorphism (new base): ");

 			base = getchar();
 			scanf("%c", &base);
 			
			if (base=='A') 	snpCdna[bp-1]='A';			
 			else if (base=='T') 	snpCdna[bp-1]='T';
 			else if (base=='G') 	snpCdna[bp-1]='G';
 			else if (base=='C') 	snpCdna[bp-1]='C';
 			 			
				}while(bp!= 0);TELOS:

			
			for(i=0;i<k;i=i+3)
 			{
 				code[0]=snpCdna[i];
				code[1]=snpCdna[i+1];
				code[2]=snpCdna[i+2];
				//	printf("  %s ",code);
				snp_prot[i/3]=check(code);
	 		}
			snp_prot[(i/3)]='\0';
			
			printf("\n\n snp.prot= \n%s  ",snp_prot);
 			printf("\n\n prot= \n%s \n", prot);	
 			fprintf(nf, "\n\n snp.prot= \n%s  ",snp_prot);
			//system("pause");
			k= strlen(prot);
			comp = (char *)malloc( (k+1)*sizeof(char) );
			comp[0]='\0';
	
			//system("pause");
	
			for (i=0;i<=k;i++)
			{
				if (prot[i]==snp_prot[i]) comp[i]=' ';
				else comp[i]='^';
			}
			comp[i]='\0';
			

		   fprintf(nf, "\n\ncompare\n%s \n%s \n%s ", prot, comp, snp_prot);
		   fclose(nf);
		  
			system("pause"); // otan eleytheronetai i mnimi kamia fora kolaei. 
											//	gi ayto exei mpei ayto edo to system pause
									 	// ta apotelesmata se kathe periptosi exoyn apothikeyti sto output file
			free(cdna);
			free(prot);
			free(snpCdna);
			free(snp_prot);	
			free(comp);
			
			  return 0;
}
			
