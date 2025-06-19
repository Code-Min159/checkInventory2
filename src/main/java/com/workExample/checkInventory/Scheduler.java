package com.workExample.checkInventory;

import com.workExample.checkInventory.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Component
public class Scheduler {

    @Autowired
    private ToDoService toDoService;
    private Scheduler(){
        ToDoService toDoService;
    }

    // 每天中午10點執行 (出貨提醒)
    @Scheduled(cron = "0 0 10  * * ?")
    public void remindShipment() throws InterruptedException {
        // 實現出貨提醒的邏輯
        System.out.println("出貨提醒: 每天中午10點執行");
        try {
            sleep(5000); // 模擬處理時間
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("出貨提醒處理完成");
    }

    //下午出貨-銷貨單確認提醒
    @Scheduled(cron = "0 30 15  * * ?")
    public void remindShipmentForm(){
        // 實現銷貨單確認提醒的邏輯
        System.out.println("銷貨單確認提醒: 每天下午3點30分執行");
        try {
            sleep(5000); // 模擬處理時間
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("銷貨單確認提醒處理完成");
    }

    // 每天下午17點30分執行 (叫料提醒)
    @Scheduled(cron = "0 30 17  * * ?")
    public void remindMaterial() throws InterruptedException {
        // 實現叫料提醒的邏輯
        System.out.println("叫料提醒: 每天下午5點30分執行");
        try {
            sleep(5000); // 模擬處理時間
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("叫料提醒處理完成");
    }

    // 每週一到五的中午12點執行 (未完成事項)
    @Scheduled(cron = "0 0 12  * * ?MON-FRI")
    public void remindUnfinishedTasks() throws InterruptedException {
        // 實現未完成事項提醒的邏輯
        System.out.println("未完成事項提醒: 每週一到五中午12點執行");
        try {
            sleep(5000); // 模擬處理時間
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("未完成事項提醒處理完成");
    }

    // 每週六的中午12點執行(需要回去的原料追蹤)
    @Scheduled(cron = "0 0 12 * * ?SAT")
    public void remindMaterialTrackingOnSaturday() throws InterruptedException {
        // 實現需要回去的原料追蹤的邏輯
        System.out.println("需要回去的原料追蹤: 每週六中午12點執行");
        try {
            sleep(5000); // 模擬處理時間
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("需要回去的原料追蹤處理完成");
    }

    //
    @Scheduled(cron = "0 0 24 * * ?")
    public String resetToDoStatus() throws InterruptedException {
        // 每天凌晨12點將所有清單狀態全部設定為未完成狀態
        System.out.println("重置ToDo狀態: 每天凌晨12點執行");
        try {
            final ToDoService toDoService = new ToDoService();
            String result = toDoService.resetAllToDoStatus();
            return result;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("ToDo狀態重置處理完成");
    }

}
