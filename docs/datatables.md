#Include DataTables in jsp page

### Link sources from New Ency CDN
Add links to jquery, datatables.sj and datatables.css from CDN module into header:
```html
<liferay-util:html-top>
    <script src= "/o/cdn/lib/jquery/jquery.min.js"></script>
    <script src= "/o/cdn/lib/datatables/datatables.min.js"></script>
    <link rel= "stylesheet" href= "/o/cdn/lib/datatables/datatables.min.css">
</liferay-util:html-top>
```

### Use datatables with rest to json api 
```javascript
var options ={
    data: [],
    columns: [
            {data: 'tableDatabase'},
            {data: 'tableName'},
            {data: 'isActive'},
            {data: 'dsaUrl'}
        ]
};

$(document).ready( function() {
    // Create datatables object     
    let table = new DataTable('#tables_tbl', options);
    
    // Query Liferay.Service json backend 
    Liferay.Service({
        '$system[tableDatabase,tableName,tableEntryId,isActive,dsaUrl] = /metacds.tableentry/get-system-tables':
            {
                systemEntryId: 1208,
                type: 'tables'
            }
        },
        function(obj) {
            // Clear old data,set the new ones and draw
            table.clear();
            table.rows.add(obj).draw();
        }
    );
});
```