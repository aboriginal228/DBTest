select p.name as project, t.name as test, timediff(t.end_time, t.start_time) as min_working_time from test t join project p on t.project_id = p.id order by p.name, t.name;