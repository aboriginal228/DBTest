select p.name as project, t.name as test from test t join project p on t.project_id = p.id where t.start_time > str_to_date('DATE', '%d-%m-%Y') order by p.name, t.name;