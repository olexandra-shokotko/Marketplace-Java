<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Marketplace</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body>
<div>
    List of users <#if product??> for product #${product.productId}</#if>
    <#list users as user>
        <div>
            <span>${user.firstname}</span>
            <span>${user.lastname}</span>
            <span>${user.amountOfMoney}</span>
        </div>
    </#list>
</div>

</body>
</html>