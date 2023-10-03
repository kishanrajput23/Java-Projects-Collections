#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct array
{
    int *AT;
    int *BT;
    int *WT;
    int *TAT;
    int *CT;
} Array;

typedef struct readyQueue
{
    int pid;
    int BT;
    struct readyQueue *next;
} ReadyQueue;

Array *userInput(int processNum, int *AT, int *BT, Array *ptr)
{

    printf("Enter the input in the form of 'Arrival Time(AT)' 'Burst Time(BT)'\n");
    for (int i = 0; i < processNum; i++)
    {
        scanf("%d %d", &AT[i], &BT[i]);
        printf("\n");
    }
    ptr->AT = AT;
    ptr->BT = BT;
    return ptr;
}

Array *sortAT(int *AT, int *BT, int proccessNum, Array *ptr)
{
    bool swapped = false;
    for (int i = 0; i < proccessNum - 1; i++)
    {
        swapped = false;
        for (int j = 0; j < proccessNum - i - 1; j++)
        {
            if (AT[j] > AT[j + 1])
            {
                int temp = AT[j];
                AT[j] = AT[j + 1];
                AT[j + 1] = temp;
                temp = BT[j];
                BT[j] = BT[j + 1];
                BT[j + 1] = temp;
                swapped = true;
            }
        }

        if (swapped == false)
        {
            break;
        }
    }

    ptr->AT = AT;
    ptr->BT = BT;
    return ptr;
}

int *calculateWT(int *WT, int processNum, int *AT, int *BT)
{
    WT[0] = 0;
    int currentTime = BT[0] + AT[0];
    for (int i = 1; i < processNum; i++)
    {
        if (AT[i] > currentTime)
        {
            currentTime = AT[i];
        }
        WT[i] = currentTime - AT[i];
        currentTime += BT[i];
    }
    return WT;
}

int *calculateTAT(int *TAT, int processNum, int *BT, int *WT)
{
    for (int i = 0; i < processNum; i++)
    {
        TAT[i] = WT[i] + BT[i];
    }

    return TAT;
}

int *calculateCT(int *CT, int proccessNum, int *AT, int *BT, int *WT)
{
    for (int i = 0; i < proccessNum; i++)
    {
        CT[i] = AT[i] + WT[i] + BT[i];
    }

    return CT;
}

void display(int *AT, int *BT, int *WT, int *TAT, int *CT, int proccessNum)
{
    printf("AT\t BT\t WT\t TAT\t CT\n");
    float avgWT = 0;
    float avgTAT = 0;
    float avgCT = 0;
    for (int i = 0; i < proccessNum; i++)
    {
        avgWT += WT[i];
        avgTAT += TAT[i];
        avgCT += CT[i];
        printf("%d\t %d\t %d\t %d\t %d\n", AT[i], BT[i], WT[i], TAT[i], CT[i]);
    }
    printf("Average WT: %f\n", avgWT / proccessNum);
    printf("Average TAT: %f\n", avgTAT / proccessNum);
    printf("Average CT: %f\n", avgCT / proccessNum);
}

Array *dynAlloc(Array *ptr, int processNum)
{
    ptr = (Array *)malloc(sizeof(Array));
    ptr->AT = (int *)malloc(processNum * sizeof(int));
    ptr->BT = (int *)malloc(processNum * sizeof(int));
    ptr->WT = (int *)malloc(processNum * sizeof(int));
    ptr->TAT = (int *)malloc(processNum * sizeof(int));
    ptr->CT = (int *)malloc(processNum * sizeof(int));
    return ptr;
}

void FCFSNecessaryFunct(int processNum, int *AT, int *BT, int *WT, int *TAT, int *CT, Array *ptr)
{
    ptr = userInput(processNum, ptr->AT, ptr->BT, ptr);
    ptr = sortAT(ptr->AT, ptr->BT, processNum, ptr);
    ptr->WT = calculateWT(ptr->WT, processNum, ptr->AT, ptr->BT);
    ptr->TAT = calculateTAT(ptr->TAT, processNum, ptr->BT, ptr->WT);
    ptr->CT = calculateCT(ptr->CT, processNum, ptr->AT, ptr->BT, ptr->WT);
    display(ptr->AT, ptr->BT, ptr->WT, ptr->TAT, ptr->CT, processNum);
}

void FCFS()
{
    int processNum;
    printf("Enter the number of processess to be executed\n");
    scanf("%d", &processNum);
    Array *ptr;
    ptr = dynAlloc(ptr, processNum);
    FCFSNecessaryFunct(processNum, ptr->AT, ptr->BT, ptr->WT, ptr->TAT, ptr->CT, ptr);
    free(ptr);
}

int *fillBT2(int processNum, int *BT, int *BT2)
{
    for (int i = 0; i < processNum; i++)
    {
        BT2[i] = BT[i];
    }

    return BT2;
}

int findMin(int processNum, int *BT2, int currentTime, int *AT)
{
    int res = 1;
    for (int i = 1; i < processNum; i++)
    {
        if (BT2[i] <= BT2[res] && BT2[i] != -1 && AT[i] <= currentTime)
        {
            res = i;
        }
        else if (BT2[res] == -1)
        {
            res++;
        }
    }
    return res;
}

int *sjfTAT(int processNum, int *AT, int *CT, int *TAT)
{
    for (int i = 0; i < processNum; i++)
    {
        TAT[i] = CT[i] - AT[i];
    }

    return TAT;
}

int *sjfWT(int processNum, int *BT, int *WT, int *TAT)
{
    for (int i = 0; i < processNum; i++)
    {
        WT[i] = TAT[i] - BT[i];
    }

    return WT;
}

int *sjfCT(int processNum, int *BT2, int *AT, int *BT, int *CT)
{
    int currentTime = BT2[0] + AT[0];
    CT[0] = currentTime;
    BT2[0] = -1;
    for (int i = 1; i < processNum; i++)
    {
        int index = findMin(processNum, BT2, currentTime, AT);
        currentTime += BT2[index];
        CT[index] = currentTime;
        BT2[index] = -1;
    }
    return CT;
}

void SJF()
{
    int proccessNum;
    printf("Enter the number of proccesses\n");
    scanf("%d", &proccessNum);
    Array *ptr;
    ptr = dynAlloc(ptr, proccessNum);
    ptr = userInput(proccessNum, ptr->AT, ptr->BT, ptr);
    ptr = sortAT(ptr->AT, ptr->BT, proccessNum, ptr);
    int *BT2 = (int *)malloc(proccessNum * sizeof(int));
    BT2 = fillBT2(proccessNum, ptr->BT, BT2);
    ptr->CT = sjfCT(proccessNum, BT2, ptr->AT, ptr->BT, ptr->CT);
    ptr->TAT = sjfTAT(proccessNum, ptr->AT, ptr->CT, ptr->TAT);
    ptr->WT = sjfWT(proccessNum, ptr->BT, ptr->WT, ptr->TAT);
    display(ptr->AT, ptr->BT, ptr->WT, ptr->TAT, ptr->CT, proccessNum);
    free(ptr);
}

ReadyQueue *enqueue(ReadyQueue *ptr, int data, int pid)
{
    ReadyQueue *newNode = (ReadyQueue *)malloc(sizeof(ReadyQueue));
    newNode->BT = data;
    newNode->pid = pid;
    newNode->next = NULL;

    if (ptr == NULL)
    {
        return newNode;
    }
    else if (data == 0)
    {
        free(newNode);
        return ptr;
    }
    else
    {
        ReadyQueue *current = ptr;
        while (current->next != NULL)
        {
            current = current->next;
        }

        current->next = newNode;

        return ptr;
    }
}

ReadyQueue *fillList(int *BT, ReadyQueue *list, int processNum)
{

    for (int i = 0; i < processNum; i++)
    {
        int pid = i + 1;
        list = enqueue(list, BT[i], pid);
    }
    return list;
}

ReadyQueue *dequeue(ReadyQueue *ptr)
{
    if (ptr == NULL)
    {
        return NULL;
    }

    ReadyQueue *temp = ptr;
    ptr = ptr->next;
    free(temp);
    return ptr;
}

int *rrCT(int *CT, int processNum, ReadyQueue *ptr, int TQ, int AT0)
{
    int currentTime = AT0;
    while (ptr != NULL)
    {
        ReadyQueue *temp = ptr;
        if (temp->BT > TQ)
        {
            temp->BT -= TQ;
            currentTime += TQ;
            ptr = enqueue(temp, temp->BT, temp->pid);
        }
        else if (temp->BT == 0)
        {
            CT[temp->pid - 1] = currentTime;
        }
        else if (temp->BT <= TQ)
        {
            CT[temp->pid - 1] = currentTime + temp->BT;
            currentTime += temp->BT;
        }
        ptr = dequeue(ptr);
    }

    return CT;
}

int *rrWT(int *WT, int *BT, int *AT, int *CT, int processNum)
{
    for (int i = 0; i < processNum; i++)
    {
        WT[i] = CT[i] - BT[i] - AT[i];
    }

    return WT;
}

int *rrTAT(int *BT, int *WT, int *TAT, int processNum)
{
    for (int i = 0; i < processNum; i++)
    {
        TAT[i] = BT[i] + WT[i];
    }

    return TAT;
}

void RR()
{
    int TQ, processNum;
    printf("Enter the time quantum for each process and the number of processess\n");
    scanf("%d %d", &TQ, &processNum);
    Array *ptr;
    ptr = dynAlloc(ptr, processNum);
    ptr = userInput(processNum, ptr->AT, ptr->BT, ptr);
    ptr = sortAT(ptr->AT, ptr->BT, processNum, ptr);
    ReadyQueue *rrListFront = (ReadyQueue *)malloc(sizeof(ReadyQueue));
    rrListFront->BT = 0;
    rrListFront->pid = 0;
    rrListFront->next = NULL;
    rrListFront = fillList(ptr->BT, rrListFront, processNum);
    ptr->CT = rrCT(ptr->CT, processNum, rrListFront, TQ, ptr->AT[0]);
    ptr->WT = rrWT(ptr->WT, ptr->BT, ptr->AT, ptr->CT, processNum);
    ptr->TAT = rrTAT(ptr->BT, ptr->WT, ptr->TAT, processNum);
    display(ptr->AT, ptr->BT, ptr->WT, ptr->TAT, ptr->CT, processNum);
    free(ptr);
}

int maxAT(int *AT, int processNum)
{
    int res = 0;
    for (int i = 1; i < processNum; i++)
    {
        if (AT[res] < AT[i])
        {
            res = i;
        }
    }

    return AT[res];
}

ReadyQueue *leastTime(ReadyQueue *ptr, int currentTime, int *AT, int processNum, int MAX_AT)
{
    ReadyQueue *temp = ptr;
    ReadyQueue *res = ptr;
    ReadyQueue *temp2 = ptr;
    temp2 = temp2->next;
    temp = temp->next;
    int BT = ptr->BT;
    if (currentTime < MAX_AT)
    {
        for (int i = ptr->pid; i < processNum; i++)
        {
            if (AT[i] == currentTime && BT > temp->BT)
            {
                BT = temp->BT;
                res = temp;
            }
            else if (AT[i] > currentTime)

            {
                break;
            }
            temp = temp->next;
        }
    }
    else
    {
        while (temp != NULL)
        {
            if (BT > temp->BT)
            {
                BT = temp->BT;
                res = temp;
            }
            temp = temp->next;
        }
    }
    while (temp2 != NULL)
    {
        if (AT[temp2->pid - 1] <= currentTime)
        {
            if (temp2->BT < res->BT)
            {
                res = temp2;
            }
            else if (temp2->BT == res->BT && temp2->pid < res->pid)
            {
                res = temp2;
            }
        }
        temp2 = temp2->next;
    }
    return res;
}

ReadyQueue *addFront(ReadyQueue *temp, ReadyQueue *ptr)
{
    if (temp == ptr)
    {
        return ptr;
    }

    ReadyQueue *prev = NULL;
    ReadyQueue *current = ptr;
    while (current != NULL && current != temp)
    {
        prev = current;
        current = current->next;
    }

    if (current == temp)
    {
        if (prev != NULL)
        {
            prev->next = temp->next;
        }
        else
        {
            ptr = temp->next;
        }

        temp->next = ptr;
        ptr = temp;
    }

    return ptr;
}

int *strfCT(int *CT, ReadyQueue *ptr, int *AT, int processNum)
{

    int currentTime = AT[0];
    int MAX_AT = maxAT(AT, processNum);
    int i = 0;
    while (ptr != NULL)
    {
        int BT = ptr->BT;
        int pid = ptr->pid;
        ReadyQueue *temp = ptr;
        ReadyQueue *head = ptr;
        if (ptr->BT != 0)
        {
            temp = leastTime(ptr, currentTime, AT, processNum, MAX_AT);
        }
        if (currentTime > MAX_AT && ptr->BT < temp->BT)
        {
            CT[ptr->pid - 1] = currentTime + ptr->BT;
            ptr = dequeue(ptr);
        }
        else if (temp->BT == ptr->BT && temp->pid < ptr->pid)
        {
            ptr = dequeue(ptr);
            ptr = enqueue(ptr, BT, pid);
            ptr = addFront(temp, ptr);
        }
        else if (ptr->next == NULL)
        {
            CT[ptr->pid - 1] = currentTime + ptr->BT;
            ptr = dequeue(ptr);
        }
        else if (ptr->BT == 0)
        {
            CT[ptr->pid - 1] = currentTime;
            ptr = dequeue(ptr);
        }
        else if (temp->BT < ptr->BT)
        {
            ptr = dequeue(ptr);
            ptr = enqueue(ptr, BT, pid);
            ptr = addFront(temp, ptr);
        }
        else if (temp->BT == ptr->BT)
        {
            currentTime++;
            ptr->BT--;
        }
    }
    return CT;
}

int *strfWT(int *AT, int *BT, int *CT, int *WT, int processNum)
{
    for (int i = 0; i < processNum; i++)
    {
        WT[i] = CT[i] - BT[i] - AT[i];
    }

    return WT;
}

int *strfTAT(int *BT, int *WT, int *TAT, int processNum)
{
    for (int i = 0; i < processNum; i++)
    {
        TAT[i] = BT[i] + WT[i];
    }

    return TAT;
}

void STRF()
{
    int processNum;
    printf("Enter the number of processess\n");
    scanf("%d", &processNum);
    Array *ptr;
    ptr = dynAlloc(ptr, processNum);
    ptr = userInput(processNum, ptr->AT, ptr->BT, ptr);
    ptr = sortAT(ptr->AT, ptr->BT, processNum, ptr);
    ReadyQueue *queue = (ReadyQueue *)malloc(sizeof(ReadyQueue));
    queue = NULL;
    queue = fillList(ptr->BT, queue, processNum);
    ptr->CT = strfCT(ptr->CT, queue, ptr->AT, processNum);
    printf("CT = %d\n", ptr->CT[0]);
    ptr->WT = strfWT(ptr->AT, ptr->BT, ptr->CT, ptr->WT, processNum);
    ptr->TAT = strfTAT(ptr->BT, ptr->WT, ptr->TAT, processNum);
    display(ptr->AT, ptr->BT, ptr->WT, ptr->TAT, ptr->CT, processNum);
    free(ptr);
}

typedef struct array2
{
    int *AT;
    int *BT;
    int *WT;
    int *TAT;
    int *CT;
    int *priority;
} Array2;

typedef struct queue
{
    int BT;
    int pid;
    int prority;
    struct queue *next;
} queue;

Array2 *dynAlloc2(Array2 *ptr, int processNum)
{
    ptr = (Array2 *)malloc(sizeof(Array2));
    ptr->AT = (int *)malloc(processNum * sizeof(int));
    ptr->BT = (int *)malloc(processNum * sizeof(int));
    ptr->WT = (int *)malloc(processNum * sizeof(int));
    ptr->TAT = (int *)malloc(processNum * sizeof(int));
    ptr->CT = (int *)malloc(processNum * sizeof(int));
    ptr->priority = (int *)malloc(processNum * sizeof(int));
    return ptr;
}

Array2 *userinputPR(Array2 *ptr, int *AT, int *BT, int *priority, int processNum)
{
    printf("Enter the input in the form of 'Priority' 'Arrival Time(AT)' 'Burst Time(BT)'\n");
    for (int i = 0; i < processNum; i++)
    {
        scanf("%d %d %d", &priority[i], &AT[i], &BT[i]);
        printf("\n");
    }
    ptr->AT = AT;
    ptr->BT = BT;
    ptr->priority = priority;
    return ptr;
}

Array2 *sortATPR(int *AT, int *BT, int *priority, int proccessNum, Array2 *ptr)
{
    bool swapped = false;
    for (int i = 0; i < proccessNum - 1; i++)
    {
        swapped = false;
        for (int j = 0; j < proccessNum - i - 1; j++)
        {
            if (AT[j] > AT[j + 1])
            {
                int temp = AT[j];
                AT[j] = AT[j + 1];
                AT[j + 1] = temp;
                temp = BT[j];
                BT[j] = BT[j + 1];
                BT[j + 1] = temp;
                temp = priority[j];
                priority[j] = priority[j + 1];
                priority[j + 1] = temp;
                swapped = true;
            }
        }

        if (swapped == false)
        {
            break;
        }
    }

    ptr->AT = AT;
    ptr->BT = BT;
    ptr->priority = priority;
    return ptr;
}

queue *enqueuePR(queue *ptr, int data, int pid, int priority)
{
    queue *newNode = (queue *)malloc(sizeof(queue));
    newNode->BT = data;
    newNode->pid = pid;
    newNode->prority = priority;
    newNode->next = NULL;

    if (ptr == NULL)
    {
        return newNode;
    }
    else if (data == 0)
    {
        free(newNode);
        return ptr;
    }
    else
    {
        queue *current = ptr;
        while (current->next != NULL)
        {
            current = current->next;
        }

        current->next = newNode;

        return ptr;
    }
}

queue *dequeuePR(queue *ptr)
{
    if (ptr == NULL)
    {
        return NULL;
    }

    queue *temp = ptr;
    ptr = ptr->next;
    free(temp);
    return ptr;
}

queue *fillListPR(int *BT, int *priority, queue *list, int processNum)
{

    for (int i = 0; i < processNum; i++)
    {
        int pid = i + 1;
        list = enqueuePR(list, BT[i], pid, priority[i]);
    }
    return list;
}

queue *addFrontPR(queue *temp, queue *ptr)
{
    if (temp == ptr)
    {
        return ptr;
    }

    queue *prev = NULL;
    queue *current = ptr;
    while (current != NULL && current != temp)
    {
        prev = current;
        current = current->next;
    }

    if (current == temp)
    {
        if (prev != NULL)
        {
            prev->next = temp->next;
        }
        else
        {
            ptr = temp->next;
        }

        temp->next = ptr;
        ptr = temp;
    }

    return ptr;
}

queue *maxPR(queue *ptr, int currentTime, int *AT, int processNum, int MAX_AT)
{
    queue *temp = ptr;
    queue *res = ptr;
    queue *temp2 = ptr;
    temp2 = temp2->next;
    temp = temp->next;
    int priority = ptr->prority;
    if (currentTime < MAX_AT)
    {
        for (int i = ptr->pid; i < processNum; i++)
        {
            if (AT[i] == currentTime && priority > temp->prority)
            {
                priority = temp->prority;
                res = temp;
            }
            else if (AT[i] > currentTime)

            {
                break;
            }
            temp = temp->next;
        }
    }
    else
    {
        while (temp != NULL)
        {
            if (priority > temp->prority)
            {
                priority = temp->prority;
                res = temp;
            }
            temp = temp->next;
        }
    }
    while (temp2 != NULL)
    {
        if (AT[temp2->pid - 1] <= currentTime)
        {
            if (temp2->prority < res->prority)
            {
                res = temp2;
            }
            else if (temp2->prority == res->prority && temp2->pid < res->pid)
            {
                res = temp2;
            }
        }
        temp2 = temp2->next;
    }
    return res;
}

int *prCT(int *CT, int *AT, queue *ptr, int processNum)
{
    int currentTime = AT[0];
    int MAX_AT = maxAT(AT, processNum);
    int i = 0;
    while (ptr != NULL)
    {
        int BT = ptr->BT;
        int pid = ptr->pid;
        int priority = ptr->prority;
        queue *temp = ptr;
        if (ptr->BT != 0)
        {
            temp = maxPR(ptr, currentTime, AT, processNum, MAX_AT);
        }
        if (currentTime >= MAX_AT && ptr == temp)
        {
            CT[ptr->pid - 1] = currentTime + ptr->BT;
            currentTime += ptr->BT;
            ptr = dequeuePR(ptr);
        }
        else if (temp->prority == ptr->prority && temp->pid < ptr->pid)
        {
            ptr = dequeuePR(ptr);
            ptr = enqueuePR(ptr, BT, pid, priority);
            ptr = addFrontPR(temp, ptr);
        }
        else if (ptr->next == NULL)
        {
            CT[ptr->pid - 1] = currentTime + ptr->BT;
            currentTime += ptr->BT;
            ptr = dequeuePR(ptr);
        }
        else if (ptr->BT == 0)
        {
            CT[ptr->pid - 1] = currentTime;
            currentTime += ptr->BT;
            ptr = dequeuePR(ptr);
        }
        else if (temp->prority < ptr->prority)
        {
            ptr = dequeuePR(ptr);
            ptr = enqueuePR(ptr, BT, pid, priority);
            ptr = addFrontPR(temp, ptr);
        }
        else if (temp->prority == ptr->prority)
        {
            currentTime++;
            ptr->BT--;
        }
    }
    return CT;
}

int *prWT(int *AT, int *BT, int *CT, int *WT, int processNum)
{
    for (int i = 0; i < processNum; i++)
    {
        WT[i] = CT[i] - BT[i] - AT[i];
    }

    return WT;
}

int *prTAT(int *BT, int *WT, int *TAT, int processNum)
{
    for (int i = 0; i < processNum; i++)
    {
        TAT[i] = BT[i] + WT[i];
    }

    return TAT;
}

void PR()
{
    int processNum;
    printf("Enter the number of proccesses\n");
    scanf("%d", &processNum);
    Array2 *ptr = dynAlloc2(ptr, processNum);
    ptr = userinputPR(ptr, ptr->AT, ptr->BT, ptr->priority, processNum);
    ptr = sortATPR(ptr->AT, ptr->BT, ptr->priority, processNum, ptr);
    queue *queue1 = (queue *)malloc(sizeof(queue));
    queue1 = NULL;
    queue1 = fillListPR(ptr->BT, ptr->priority, queue1, processNum);
    ptr->CT = prCT(ptr->CT, ptr->AT, queue1, processNum);
    ptr->WT = prWT(ptr->AT, ptr->BT, ptr->CT, ptr->WT, processNum);
    ptr->TAT = prTAT(ptr->BT, ptr->WT, ptr->TAT, processNum);
    display(ptr->AT, ptr->BT, ptr->WT, ptr->TAT, ptr->CT, processNum);
    free(ptr);
}

int *nonPRCT(int *CT, int *AT, queue *ptr, int processNum)
{
    int currentTime = AT[0];
    int MAX_AT = maxAT(AT, processNum);
    while (ptr != NULL)
    {
        int BT = ptr->BT;
        int pid = ptr->pid;
        int priority = ptr->prority;
        queue *temp = ptr;
        queue *head = ptr;
        if (ptr->BT != 0)
        {
            temp = maxPR(ptr, currentTime, AT, processNum, MAX_AT);
        }
        if (ptr == temp)
        {
            CT[ptr->pid - 1] = currentTime + ptr->BT;
            currentTime += ptr->BT;
            ptr = dequeuePR(ptr);
        }
        else if (currentTime >= MAX_AT && ptr == temp)
        {
            CT[ptr->pid - 1] = currentTime + ptr->BT;
            currentTime += ptr->BT;
            ptr = dequeuePR(ptr);
        }
        else if (temp->prority < ptr->prority)
        {
            CT[ptr->pid - 1] = currentTime + ptr->BT;
            currentTime += ptr->BT;
            ptr = dequeuePR(ptr);
            ptr = addFrontPR(temp, ptr);
        }
        else if (temp->prority == ptr->prority && temp->pid < ptr->pid)
        {
            CT[ptr->pid - 1] = currentTime + ptr->BT;
            currentTime += ptr->BT;
            ptr = dequeuePR(ptr);
            ptr = addFrontPR(temp, ptr);
        }
    }

    return CT;
}

void nonPR()
{
    int processNum;
    printf("Enter the number of processess\n");
    scanf("%d", &processNum);
    Array2 *ptr;
    ptr = dynAlloc2(ptr, processNum);
    ptr = userinputPR(ptr, ptr->AT, ptr->BT, ptr->priority, processNum);
    ptr = sortATPR(ptr->AT, ptr->BT, ptr->priority, processNum, ptr);
    queue *queue1 = (queue *)malloc(sizeof(queue));
    queue1 = NULL;
    queue1 = fillListPR(ptr->BT, ptr->priority, queue1, processNum);
    ptr->CT = nonPRCT(ptr->CT, ptr->AT, queue1, processNum);
    ptr->WT = prWT(ptr->AT, ptr->BT, ptr->CT, ptr->WT, processNum);
    ptr->TAT = prTAT(ptr->BT, ptr->WT, ptr->TAT, processNum);
    display(ptr->AT, ptr->BT, ptr->WT, ptr->TAT, ptr->CT, processNum);
    free(ptr);
}

void main()
{
    int choice;
    char option;
    while (choice != 6)
    {
        printf("Choose the CPU scheduling\n 1.FCFS\n 2.SJF\n 3.RR\n 4.STRF\n 5.PR\n 6.Exit\n");
        scanf("%d", &choice);

        switch (choice)
        {
        case 1:
            FCFS();
            break;

        case 2:
            SJF();
            break;

        case 3:
            RR();
            break;

        case 4:
            STRF();
            break;

        case 5:
            printf("Do you want to continue with preemptive Y or N? \n");
            scanf("%c", &option);
            scanf("%c", &option);
            if (option == 'Y')
            {
                PR();
            }
            else if (option == 'N')
            {
                nonPR();
            }
            break;

        case 6:
            break;

        default:
            break;
        }
    }
}
