use travlos;

select * from receptor where receptor.name like '%a%';


select receptor.receptor_id from receptor where receptor.name='CANNABINOID CB1';

select interaction.recepid from interaction where interaction.recepid='1';









select receptor.receptor_id from receptor where receptor.name='CANNABINOID CB1';

select interaction.recepid from interaction where interaction.recepid='1';
1
select interaction.ligid from interaction where interaction.recepid='1' or interaction.recepid='2' or interaction.recepid='3' or interaction.recepid='4' or interaction.recepid='15' or interaction.recepid='23';
1
select ligand.ligand_id from ligand where ligand.ligand_id='1';
select * from receptor where (receptor.name like '%a%' or receptor.unigene like '%a%');

1
select * from ligand where ligand.ligand_id='1';

select ligand.*, interaction.ki from receptor	inner join interaction on interaction.recepid=receptor.receptor_id inner join ligand on ligand.ligand_id=interaction.ligid where receptor.name='CANNABINOID CB1';


select ligand.*,interaction.ki from receptor
inner join interaction on interaction.recepid=receptor.receptor_id
inner join ligand on ligand.ligand_id=interaction.ligid
where receptor.name='CANNABINOID CB1';

select ligand.* from receptor,interaction,ligand
where interaction.recepid= receptor.receptor_id
and ligand.ligand_id=interaction.ligid
and receptor.name='CANNABINOID CB1';


