select browser, count(name) as runs from test
where browser = 'BROWSER'
group by browser