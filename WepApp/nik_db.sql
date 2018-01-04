
create table _snp
(
	sid varchar(44) primary key, /* SNP Identifier */
    class varchar(44),
    chromosome varchar(44),
    conseq varchar(44)
);



create table _gene
(
	gid varchar(44) primary key, /* Entrez Identifier */
    
    fname varchar(111),
    geneSymbol varchar(44),
    uniprot varchar(44)
);

		create table _path
		(
			pg_gid varchar(44),        
			path varchar(44),
			
			constraint pk_gene_path primary key (pg_gid,path),
			constraint fk_gene_path foreign key (pg_gid) references _gene(gid)     
			
		);
		
        CREATE TABLE _class
        (
			cl_gid varchar(44),
            class varchar(44),
            
            constraint pk_gene_class primary key (cl_gid,class),
			constraint fk_gene_class foreign key (cl_gid) references _gene(gid)
		);
    
    
create table _disease
(
	did varchar(44) primary key, 	/* UMLS CUI */
    dName varchar(44),
    dType varchar(44),
    omim varchar(44),
    semanticType varchar(44),
    dOntology varchar(111),
    mesh varchar(44)
);

		create table _fen
		(
			fen_did varchar(44),        
			fen varchar(66),
            
			constraint pk_dis_fen primary key (fen_did,fen),
			constraint fk_dis_fen foreign key (fen_did) references _disease(did) 
			
		);
    
		
		create table _mesh
		(
			mes_did varchar(44),        
			mesh_class varchar(66),
			
			constraint pk_dis_mes primary key (mes_did,mesh_class),
			constraint fk_dis_mes foreign key (mes_did) references _disease(did)     
			
		);
		
    

create table _gene_dis
(
	gd_gid varchar(44),
    gd_did varchar(44),
    
    constraint fk_gene_dis primary key (gd_gid,gd_did),
    constraint fk_gd_gg foreign key (gd_gid) references _gene(gid),
    constraint fk_gd_dd foreign key (gd_did) references _disease(did)
);

		create table _evidence
		(
			eid varchar(44),
			evi_gid varchar(44),
			evi_did varchar(44),
			
			sentence varchar(444),
			
			constraint fk_evi primary key (eid,evi_gid,evi_did),
			constraint fk_gene_evi foreign key (evi_gid) references _gene_dis(gd_gid),
			constraint fk_dis_evi foreign key (evi_did) references _gene_dis(gd_did)
		);


create table _snp_dis
(
	sd_did varchar(44),
    sd_sid varchar(44),
    
    constraint fk_snp_dis primary key (sd_did,sd_sid),
    constraint fk_sd_ss foreign key (sd_sid) references _snp(sid),
    constraint fk_sd_dd foreign key (sd_did) references _disease(did)
);

create table _snp_gene
(
	sg_sid varchar(44),
    sg_gid varchar(44),
    
    constraint fk_snp_gene primary key (sg_sid,sg_gid),
    constraint fk_sg_gg foreign key (sg_gid) references _gene(gid),
    constraint fk_sg_ss foreign key (sg_sid) references _snp(sid)
);
    
    