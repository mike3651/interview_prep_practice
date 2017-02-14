'''
def merge(node a, node b):
	node c = curr = NULL
	while(a != null && b != null):
		if a->data < b->data:
			if c == NULL:
				c = a
				c.next = NULL
				curr = c
			else:
				curr->next = a
				curr = curr->next
		else:
		 	if c == NULL:
				c = b
				c.next = NULL
				curr = c
			else:
				curr->next = b
				curr = curr->next
	while(a != null):
		curr->next = a
		a = a->next
		curr = curr->next
	while(b != null):
		curr->next = b
		b = b->next
		curr = curr->next
	return curr

'''

map<String, int> m = new HashMap<>()