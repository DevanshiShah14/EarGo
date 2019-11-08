
select
	    "Home_Page" as Page,
	    SUM(Home_Page) as counts
	    from Input_table
	union all
	select
	 "Product_Page" as Page,
	    SUM(Product_Page) as counts
	    from Input_table
	union all
	select
	 "Warranty_Page" as Page,
	    SUM(Warranty_Page) as counts
	    from Input_table;