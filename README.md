- Given 容量小于等于0 When 初始化Locker Then 初始化失败，抛出异常
- Given Locker有可用容量 When 存包 Then 存包成功，返回票据
- Given Locker没有可用容量 When 存包 Then 存包是否，提示储物柜已满
- Given 一张有效票据 When 取包 Then 取包成功
- Given 一张无效票据 When 取包 Then 取包失败，提示无效票据
