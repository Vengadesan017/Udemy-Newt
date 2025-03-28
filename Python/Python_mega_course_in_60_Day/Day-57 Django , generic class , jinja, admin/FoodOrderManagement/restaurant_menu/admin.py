from django.contrib import admin
from .models import Item

class MenuItemAdmin(admin.ModelAdmin):
    list_display = ("meal","status")    # show the status of food in the view table
    list_filter = ("status",)     # filter in right side
    search_fields = ("meal","description")   # top search bar


admin.site.register(Item,MenuItemAdmin)