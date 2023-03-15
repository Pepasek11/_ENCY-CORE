const services = {
    roles:{
        getMany:'/delegations.delegatedrole/get-roles',
        getOne:'/delegations.delegatedrole/get-role',
        updateOne: '/delegations.delegatedrole/update',
        deleteOne:'/delegations.delegatedrole/delete',
    },
    delegations:{
        getMany: '/delegations.delegation/get-delegations',
        getOne: '/delegations.delegation/get-delegation',
        updateOne:'/delegations.delegation/update-delegation',
        deleteOne:'/delegations.delegation/delete-delegation'
    }
}

export {services}