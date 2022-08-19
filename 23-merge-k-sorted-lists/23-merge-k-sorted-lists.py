# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
            
        ListNode.__gt__ = lambda self, other : self.val > other.val
    
        dummy = current = ListNode()
        heap = []
        
        for l in lists:
            if l:
                heapq.heappush(heap, (l.val, l))
        
        while len(heap):
            popped = heapq.heappop(heap)
            current.next = popped[1]
            current = current.next
            
            if popped[1].next:
                heapq.heappush(heap, (popped[1].next.val, popped[1].next))
        
        return dummy.next