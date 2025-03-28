from django.shortcuts import render
from django.views import generic
from .models import Item, MEAL_TYPE


class MenuList(generic.ListView):
    # queryset = {}
    queryset = Item.objects.order_by("-date_created")
    template_name = "index.html"

    def get_context_data(self, **kwargs):
        # context = {}
        context = super().get_context_data(**kwargs)
        context["meals"] = MEAL_TYPE

        return context


class MenuItemDetail(generic.DetailView):
    model = Item
    template_name = "menu_item_details.html"

