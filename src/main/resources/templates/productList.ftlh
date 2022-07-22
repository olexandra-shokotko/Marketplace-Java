<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Marketplace</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body>
<div>
    List of products <#if user??> for user #${user.userId}</#if>
    <#list products as product>
        <div>
            <span>${product.name}</span>
            <span>${product.price}</span>
        </div>
    </#list>
</div>

</body>
</html>