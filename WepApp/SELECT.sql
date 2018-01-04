SELECT * FROM disease
WHERE D_id='C0000768';

create view koytakidisease as
SELECT D_id,type,MesH,OMIM,semantic_type,ontology,d.name,phenotype,meshclass FROM disease d JOIN phenotype_dis ON
D_id=diseas_id join meshclass_disease on
D_id=di_id;

select * from koytakidisease;

select id_gene,id_disease,evidence,count(*) from evidencegene
group by id_gene;

select * from disease
where name like '%neo%';

select * from dis_gene_assoc
where dis_id='C0000768';


select snp_id,disease_id,name,score from snp_dis_assoc join disease on
disease_id=D_id;

select gene_Symbol,id_disease,evidence,name,type,MesH,OMIM,semantic_type,ontology from dis_gene_assoc join evidencegene
on id_gene=gene_Symbol join disease on
id_disease=D_id;

select snp_id,score from snp_dis_assoc where disease_id='C0004943';


















